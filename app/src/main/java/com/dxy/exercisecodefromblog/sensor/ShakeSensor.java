package com.dxy.exercisecodefromblog.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by author_dang on 16/6/10.
 */
public class ShakeSensor implements SensorEventListener {

    private Context mContext;
    private SensorManager mSensorManager;
    private Sensor mSensor;

    private long lastTime;

    private float last_x;
    private float last_y;

    private float last_z;

    private OnShakeListener mOnShakeListener;

    public ShakeSensor() {
    }


    public ShakeSensor(Context context) {
        this.mContext = context;
    }

    public  void init() {

        mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);

        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);


    }

    public void unRegisterListener() {
        mSensorManager.unregisterListener(this, mSensor);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        long currentTime = System.currentTimeMillis();
        double timeDistance = 0;
        float x = event.values[0];

        float y = event.values[1];

        float z = event.values[2];



        if (currentTime - lastTime > 10) {
            timeDistance = currentTime - lastTime;
            lastTime = currentTime;
        }


        double speed;

        double absValue = Math.abs(x + y + z - last_x - last_y - last_z);


        speed = absValue / timeDistance * 10000;

        if (speed > 5600) {

            if(null!= mOnShakeListener){
            mOnShakeListener.OnShake();
            }
        }
        last_x = x;
        last_y = y;
        last_z = z;


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface OnShakeListener{
        void OnShake();
    }

    public void setOnShakeListener(OnShakeListener onShakeListener){

        this.mOnShakeListener = onShakeListener;
    }
}
