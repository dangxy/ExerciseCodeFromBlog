package com.dxy.exercisecodefromblog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by author_dang on 16/6/10.
 */
public class CircleView extends View {

    private Paint mPaint;

    private float mHeigth;

    private float mWidth;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initData();
    }

    private void initData() {

        mPaint = new Paint();

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setAntiAlias(true);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mHeigth = getWidth();

        mWidth = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {


        mPaint.setColor(Color.BLACK);

        canvas.translate(200, 200);

        canvas.drawCircle(0, 0, 100, mPaint);


        mPaint.setColor(Color.BLACK);

        canvas.translate(200, 200);

        canvas.drawCircle(0, 0, 100, mPaint);

        canvas.translate(200,200);


        RectF  rectF = new RectF(0,-400,400,0);

        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setColor(Color.BLACK);

        canvas.drawRect(rectF,mPaint);


        canvas.scale(0.5f,0.5f);



        mPaint.setColor(Color.BLUE);

        canvas.drawRect(rectF,mPaint);

    }
}
