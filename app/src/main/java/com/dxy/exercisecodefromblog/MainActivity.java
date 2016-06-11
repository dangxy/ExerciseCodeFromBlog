package com.dxy.exercisecodefromblog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dxy.exercisecodefromblog.activity.CustomViewActivity;
import com.dxy.exercisecodefromblog.camera.TakeCameraActivity;
import com.dxy.exercisecodefromblog.picture.PictureActivity;
import com.dxy.exercisecodefromblog.sensor.SensorActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.bt_camera)
    Button btCamera;
    @InjectView(R.id.bt_circle_view)
    Button btCircleView;
    @InjectView(R.id.bt_sensor)
    Button btSensor;
    @InjectView(R.id.bt_picture)
    Button btPicture;


    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mContext = this;

        initView();
    }

    private void initView() {
        btCamera.setOnClickListener(this);

        btCircleView.setOnClickListener(this);

        btSensor.setOnClickListener(this);

        btPicture.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_camera:
                Intent intent = new Intent(mContext, TakeCameraActivity.class);

                startActivity(intent);
                break;

            case R.id.bt_circle_view:
                intent = new Intent(mContext, CustomViewActivity.class);

                startActivity(intent);
                break;

            case R.id.bt_sensor:
                intent = new Intent(mContext, SensorActivity.class);

                startActivity(intent);
                break;

            case R.id.bt_picture:
                intent = new Intent(mContext, PictureActivity.class);

                startActivity(intent);
                break;
        }
    }
}
