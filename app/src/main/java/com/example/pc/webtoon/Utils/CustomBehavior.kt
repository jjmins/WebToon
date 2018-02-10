package com.example.pc.webtoon.Utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by pc on 2018-01-27.
 */

class CustomBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
    private var mDySinceDirectionChange = 0

    private var animState = ANIM_STATE_NONE


    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        Log.e("scrolltest", (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL).toString())
        Log.e("scollvisible", child.visibility.toString())
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }


    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        // 스크롤방향이 바뀌는경우 초기화
        if (dy > 0 && mDySinceDirectionChange < 0 || dy < 0 && mDySinceDirectionChange > 0) {
            Log.e("cancle", "초기화")
            child.animate().cancel()
            mDySinceDirectionChange = 0
        }

        mDySinceDirectionChange += dy

        Log.e("mDySinceDirectionChange", mDySinceDirectionChange.toString())
        if (dy > 0 && !isOrWillBeShown(child)) {            //hideView(child);
           hide(child)//true
            Log.d("hideView", "hide")
        } else if (dy < 0 && !isOrWillBeHidden(child)) {
            show(child)
            Log.e("showView", "show")
        }
    }

    private fun isOrWillBeHidden(view: View): Boolean {
        return if (view.visibility == View.VISIBLE) {
            animState != ANIM_STATE_HIDING // 0 - 1
        } else {
            animState == ANIM_STATE_SHOWING// 0 - 2 = flase
        }
    }

    private fun isOrWillBeShown(view: View): Boolean {
        return if (view.visibility != View.VISIBLE) {
            animState != ANIM_STATE_SHOWING  // 0 - 1
        } else {
            animState == ANIM_STATE_HIDING  //  0 - 2  = flase
        }
    }

    private fun hide(view: View) {
        view.animate().cancel()

        view.animate()
                .translationY(view.height.toFloat())
                .setInterpolator(INTERPOLATOR)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    private var isCanceled = false

                    override fun onAnimationStart(animation: Animator) {
                        animState = ANIM_STATE_HIDING//1
                        isCanceled = false
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationCancel(animation: Animator) {
                        isCanceled = true
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        animState = ANIM_STATE_NONE
                        if (!isCanceled) {
                            view.visibility = View.INVISIBLE
                        }
                    }
                })
    }

    private fun show(view: View) {
        view.animate().cancel()

        view.animate()
                .translationY(0f)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animator: Animator) {
                        animState = ANIM_STATE_SHOWING
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animator: Animator) {
                        animState = ANIM_STATE_NONE
                    }
                })
    }

    companion object {
        private val INTERPOLATOR = FastOutSlowInInterpolator()

        private val ANIM_STATE_NONE = 0
        private val ANIM_STATE_HIDING = 1
        private val ANIM_STATE_SHOWING = 2
    }
}
