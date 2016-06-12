package com.dxy.exercisecodefromblog.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by author_dang on 16/6/12.
 */
public class PathView extends View {

    private Paint mPaint;

    private int mWidth;
    private int mHeight;

    private Context mContext;

    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext= context;
        initPaint();
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    private void initPaint(){

        mPaint = new Paint();

        mPaint.setColor(Color.BLUE);

        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setStrokeWidth(10);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        WindowManager windowManager= (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);


        mHeight= windowManager.getDefaultDisplay().getHeight();

        mWidth= windowManager.getDefaultDisplay().getWidth();




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth/2,mHeight/2);

        canvas.scale(1,-1);

        Path path = new Path();

        //path.lineTo(200,200);


        //path.lineTo(200,0);

        //path.close();

        //canvas.drawPath(path,mPaint);

        Path src = new Path();

        src.addCircle(0,0,100, Path.Direction.CW);


        path.addRect(-200,-200,200,200, Path.Direction.CW);

        path.addPath(src,0,200);

        canvas.drawPath(path,mPaint);
    }
}
