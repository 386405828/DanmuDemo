package com.tidemedia.danmudemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {

    private static final String TAG = "ResizeLayout";
    private Context context;

    public ResizeLayout(Context context) {
        super(context);
        this.context = context;
    }

    public ResizeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    private OnResizeListener mListener;

    public interface OnResizeListener {

        void OnResize(int w, int h, int oldw, int oldh);
    }

    public void setOnResizeListener(OnResizeListener l) {
        mListener = l;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mListener != null) {
            mListener.OnResize(w, h, oldw, oldh);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            closeKeyboard();
        }
        return super.onTouchEvent(event);
    }

    private void closeKeyboard() {
        ((InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(this.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
    }
}