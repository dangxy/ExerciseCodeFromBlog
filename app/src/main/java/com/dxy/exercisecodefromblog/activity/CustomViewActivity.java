package com.dxy.exercisecodefromblog.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;

import com.dxy.exercisecodefromblog.R;
import com.dxy.exercisecodefromblog.view.CircleView;
import com.dxy.exercisecodefromblog.view.WaveView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomViewActivity extends AppCompatActivity {

    @InjectView(R.id.circle_view)
    CircleView circleView;
    @InjectView(R.id.wave_view)
    WaveView mWaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.inject(this);

        initData();
    }
    private void initData(){
        mWaveView = (WaveView) findViewById(R.id.wave_view);
        mWaveView.setDuration(5000);
        mWaveView.setStyle(Paint.Style.STROKE);
        mWaveView.setSpeed(400);
        mWaveView.setColor(Color.parseColor("#ff0000"));
        mWaveView.setInterpolator(new AccelerateInterpolator(1.2f));
        mWaveView.start();

//        mWaveView = (WaveView) findViewById(R.id.wave_view);
//        mWaveView.setDuration(5000);
//        mWaveView.setStyle(Paint.Style.FILL);
//        mWaveView.setColor(Color.parseColor("#ff0000"));
//        mWaveView.setInterpolator(new LinearOutSlowInInterpolator());
//        mWaveView.start();
    }
}
