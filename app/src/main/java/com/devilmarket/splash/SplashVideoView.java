package com.devilmarket.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

import androidx.annotation.Nullable;

public class SplashVideoView extends VideoView {
    public SplashVideoView(Context context) {
        super(context);
    }

    public SplashVideoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SplashVideoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
