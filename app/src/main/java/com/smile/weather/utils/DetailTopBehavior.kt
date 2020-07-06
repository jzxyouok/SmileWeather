package com.smile.weather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * 控制 详情页面顶部内容
 */
class DetailTopBehavior constructor(context: Context, attrs: AttributeSet) :
    CoordinatorLayout.Behavior<View>(context, attrs) {


    // 列表顶部和title底部重合时，列表的滑动距离。
    private var deltaY=0f
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is RecyclerView;
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        if (deltaY == 0f){
            deltaY= dependency.y-child.height
        }
        var dy=dependency.y-child.height
        dy=if (dy<0) 0F else dy

        val y = -(dy / deltaY) * child.height
        val alpha = 1 - dy / deltaY

        child.alpha = alpha;

        return true
    }

}