package com.dxy.exercisecodefromblog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by author_dang on 16/6/10.
 */
public class CircleView extends View {

    private Paint mPaint;

    private float mHeigth;

    private float mWidth;

    private Context mContext;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext= context;
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

        WindowManager windowManager =(WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mHeigth = windowManager.getDefaultDisplay().getHeight();

        mWidth =windowManager.getDefaultDisplay().getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {


//        mPaint.setColor(Color.BLACK);
//
//        canvas.translate(mWidth/2,mHeigth/2);
//
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//
//        mPaint.setColor(Color.BLACK);
//
//        canvas.translate(200, 200);
//
//        canvas.drawCircle(0, 0, 100, mPaint);
//
//
//
//
//        RectF  rectF = new RectF(0,-400,400,0);
//
//        mPaint.setStyle(Paint.Style.STROKE);
//
//        mPaint.setColor(Color.BLACK);
//
//        canvas.drawRect(rectF,mPaint);
//
//
//        canvas.scale(0.5f,0.5f);
//
//
//
//        mPaint.setColor(Color.BLUE);
//
//        canvas.drawRect(rectF,mPaint);

        canvas.translate(mWidth/2,mHeigth/2);

        mPaint.setColor(Color.BLUE);

        mPaint.setStrokeWidth(20);

        mPaint.setStyle(Paint.Style.STROKE);




        for(int i = 0 ;i<=20;i++ ){
            canvas.scale(0.9f,0.9f);

            canvas.drawCircle(0,0,mWidth/2,mPaint);

        }





    }
}
