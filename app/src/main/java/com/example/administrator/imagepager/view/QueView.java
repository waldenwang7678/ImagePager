package com.example.administrator.imagepager.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class QueView extends View {

    Paint mPaint;
    int mWidth;
    int mHeight;
    Path mPath;
    int slop = 10;

    public QueView(Context context) {
        super(context);
        init();
    }

    public QueView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public QueView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = width;  //初始化默认大小
        mHeight = height;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) { //精确
            mWidth = width;
        } else {
            mWidth = Math.min(width, 600);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = height;
        } else {
            mHeight = Math.min(height, 500);
        }
        setMeasuredDimension(mWidth, mHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath = new Path();
        mPath.moveTo(slop, slop);
        mPath.quadTo(mWidth - slop, slop, mWidth - slop, mHeight - slop);

        canvas.drawPath(mPath, mPaint);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);

    }
}
