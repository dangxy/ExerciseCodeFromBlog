package com.dxy.exercisecodefromblog.sensor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dxy.exercisecodefromblog.R;

import java.io.File;
import java.io.FileOutputStream;

public class SensorActivity extends AppCompatActivity  implements ShakeSensor.OnShakeListener{

    private ShakeSensor mShakeSensor;

    private Vibrator mVibrator;

    private boolean first=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        initData();
    }

    private void initData() {


        mShakeSensor = new ShakeSensor(this);

        mShakeSensor.init();

        mShakeSensor.setOnShakeListener(this);

        mVibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);

    }

    @Override
    public void OnShake() {

      //  Toast.makeText(getApplicationContext(),"摇一摇",Toast.LENGTH_SHORT).show();


     if(first){
         screenshot();
     }


    }

    private void screenshot()
    {

        first=false;
        // 获取屏幕
        View dView = getWindow().getDecorView();
        dView.setDrawingCacheEnabled(true);
        dView.buildDrawingCache();
        Bitmap bmp = dView.getDrawingCache();
        if (bmp != null)
        {
            try {
                // 获取内置SD卡路径
                String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                // 图片文件路径
                String filePath = sdCardPath + File.separator + "screenshot.png";

                File file = new File(filePath);
                FileOutputStream os = new FileOutputStream(file);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, os);

                Toast.makeText(getApplicationContext(),"screenshot.png",Toast.LENGTH_SHORT).show();
                os.flush();
                os.close();
            } catch (Exception e) {
            }
        }
    }
}
