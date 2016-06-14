package com.dxy.exercisecodefromblog.factory;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.dxy.exercisecodefromblog.R;

public class LayoutInflaterActivity extends AppCompatActivity {

    private static final String TAG = "LayoutInflaterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {


                Log.e(TAG,"name = "+name);

                if(name.equals("TextView")){
                    Button button = new Button(context,attrs);

                    return  button;
                }

                int n = attrs.getAttributeCount();

                for(int i  = 0 ;i<n;i++){
                    Log.e(TAG,attrs.getAttributeName(i)+","+attrs.getAttributeValue(i));
                }
                return null;
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);

    }
}
