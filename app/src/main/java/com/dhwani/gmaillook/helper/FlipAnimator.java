package com.dhwani.gmaillook.helper;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;

import com.dhwani.gmaillook.R;

public class FlipAnimator {

    private static String TAG = FlipAnimator.class.getSimpleName();
    private static AnimatorSet leftIN, rightOut, leftOut, rightIn;

    public static void flipview(Context context, final View back, final View front, boolean showFront) {
        leftIN = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_left_in);
        leftOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_left_out);
        rightIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_right_in);
        rightOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.card_flip_right_out);


        final AnimatorSet showFrontAnim = new AnimatorSet();
        final AnimatorSet showBackAnim = new AnimatorSet();

        leftIN.setTarget(back);
        rightOut.setTarget(front);

        showBackAnim.playTogether(leftIN, rightOut);

        leftOut.setTarget(back);
        rightIn.setTarget(front);

        showBackAnim.playTogether(rightIn, leftOut);

        if (showFront) {
            showFrontAnim.start();
        } else {
            showBackAnim.start();
        }
    }

}
