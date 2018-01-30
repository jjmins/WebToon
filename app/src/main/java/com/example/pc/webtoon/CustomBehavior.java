package com.example.pc.webtoon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by pc on 2018-01-27.
 */

public class CustomBehavior extends CoordinatorLayout.Behavior<View> {
    private static final FastOutSlowInInterpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private int mDySinceDirectionChange = 0;

    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_SHOWING = 2;

    private int animState = ANIM_STATE_NONE;

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.e("scrolltest", String.valueOf(nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL));
        Log.e("scollvisible", String.valueOf(child.getVisibility()));
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }



    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        // 스크롤방향이 바뀌는경우 초기화
        if (dy > 0 && mDySinceDirectionChange < 0
                || dy < 0 && mDySinceDirectionChange > 0) {
            Log.e("cancle","초기화");
            child.animate().cancel();
            mDySinceDirectionChange = 0;
        }

        mDySinceDirectionChange += dy;
        Log.e("dydy", String.valueOf(dy));
        Log.e("mDySinceDirectionChange", String.valueOf(mDySinceDirectionChange));
        if (mDySinceDirectionChange >0 && !isOrWillBeHidden(child)) {            //hideView(child);
            show(child);
            Log.d("hideView","반응");
        } else if (mDySinceDirectionChange < 0 && !isOrWillBeShown(child)) {
            hide(child);
            Log.e("showView","반응");
        }
    }

//    @Override
//    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
//
//    }

    private boolean isOrWillBeHidden(View view) {
        if (view.getVisibility() != View.VISIBLE) {
            return animState == ANIM_STATE_HIDING;
        } else {
            return animState != ANIM_STATE_SHOWING;
        }
    }

    private boolean isOrWillBeShown(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            return animState == ANIM_STATE_SHOWING;
        } else {
            return animState != ANIM_STATE_HIDING;
        }
    }

    private void hide(final View view) {
        view.animate().cancel();

        view.animate()
                .translationY(view.getHeight())
                .setInterpolator(INTERPOLATOR)
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    private boolean isCanceled = false;

                    @Override public void onAnimationStart(Animator animation) {
                        animState = ANIM_STATE_HIDING;
                        isCanceled = false;
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override public void onAnimationCancel(Animator animation) {
                        isCanceled = true;
                    }

                    @Override public void onAnimationEnd(Animator animation) {
                        animState = ANIM_STATE_NONE;
                        if (!isCanceled) {
                            view.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }

    /**
     * Show the quick return view.
     * <p>
     * Animates showing the view, with the view sliding up from the bottom of the screen.
     * After the view has reappeared, its visibility will change to VISIBLE.
     *
     * @param view The quick return view
     */
    private void show(final View view) {
        view.animate().cancel();

        view.animate()
                .translationY(0f)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override public void onAnimationStart(Animator animator) {
                        animState = ANIM_STATE_SHOWING;
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override public void onAnimationEnd(Animator animator) {
                        animState = ANIM_STATE_NONE;
                    }
                });
    }
}
