package com.lin.cardlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * <pre>
 *     @desc: 作为 SwipeTouchLayout 子 view，避免 recyclerview 的 item 点击事件无法响应。
 *            或自己定义 view 处理相应的事件结局无法点击问题。
 * </pre>
 *
 * @author imtianx
 * @email imtianx@gmail.com
 * @date 2020/3/28 3:11 PM
 */
public class SwipeTouchLayoutChildView extends FrameLayout {


    public SwipeTouchLayoutChildView(@NonNull Context context) {
        super(context);
    }

    public SwipeTouchLayoutChildView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeTouchLayoutChildView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null && event.getAction() == MotionEvent.ACTION_MOVE) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        if (event != null && event.getAction() == MotionEvent.ACTION_MOVE) {
            return false;
        }
        return super.dispatchHoverEvent(event);
    }
}
