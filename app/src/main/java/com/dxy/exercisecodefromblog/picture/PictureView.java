package com.dxy.exercisecodefromblog.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.dxy.exercisecodefromblog.R;

/**
 * Created by author_dang on 16/6/11.
 */
public class PictureView extends View {

    private Context mConetxt;

    private Bitmap bitmap;

    private Paint mPaint;

    public PictureView(Context context) {
        this(context, null);
    }

    public PictureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mConetxt = context;
        initPaint();
    }

    private void initPaint() {


        mPaint = new Paint();

        mPaint.setColor(Color.BLUE);


        bitmap = BitmapFactory.decodeResource(mConetxt.getResources(), R.mipmap.a);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        //canvas.drawBitmap(bitmap, new Matrix(), mPaint);

        canvas.drawBitmap(bitmap,50,100,mPaint);
    }
}
