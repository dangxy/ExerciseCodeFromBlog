package com.dxy.exercisecodefromblog.view.attr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.dxy.exercisecodefromblog.R;

/**
 * Created by author_dang on 16/6/12.
 */
public class MyTextView extends View {

    private  static final  String TAG = MyTextView.class.getSimpleName();

    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);

        String text = typedArray.getString(R.styleable.MyTextView_text);

        int  textAttr = typedArray.getInteger(R.styleable.MyTextView_textAttr,-1);

        Log.e(TAG,"text="+text+",textAttr="+textAttr);



        int count = attrs.getAttributeCount();

        for(int i = 0 ;i<count;i++){
            String attrName = attrs.getAttributeName(i);
            String attrValue= attrs.getAttributeValue(i);

            Log.e(TAG,attrName+"=="+attrValue);

        }

        typedArray.recycle();
    }
}
