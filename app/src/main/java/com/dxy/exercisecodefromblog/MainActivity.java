package com.dxy.exercisecodefromblog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dxy.exercisecodefromblog.Recycler.RecyclerViewActivity;
import com.dxy.exercisecodefromblog.activity.CustomViewActivity;
import com.dxy.exercisecodefromblog.camera.TakeCameraActivity;
import com.dxy.exercisecodefromblog.factory.LayoutInflaterActivity;
import com.dxy.exercisecodefromblog.menu.MenuActivity;
import com.dxy.exercisecodefromblog.mvp.bean.activity.UserLoginActivity;
import com.dxy.exercisecodefromblog.notifications.NotificationsActivity;
import com.dxy.exercisecodefromblog.path.PathActivity;
import com.dxy.exercisecodefromblog.picture.PictureActivity;
import com.dxy.exercisecodefromblog.sensor.SensorActivity;
import com.dxy.exercisecodefromblog.springview.SpringViewActivity;
import com.dxy.exercisecodefromblog.takephoto.PhotoActivity;
import com.dxy.exercisecodefromblog.takephoto.PictureRotateActivity;
import com.dxy.exercisecodefromblog.viewpager.AutoViewpagerActivity;

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
    @InjectView(R.id.bt_path)
    Button btPath;
    @InjectView(R.id.bt_mvp_login)
    Button btMvpLogin;
    @InjectView(R.id.bt_take_photo)
    Button btTakePhoto;
    @InjectView(R.id.bt_layout_inflater)
    Button btLayoutInflater;
    @InjectView(R.id.bt_picture_rotate)
    Button btPictureRotate;
    @InjectView(R.id.bt_menu)
    Button btMenu;
    @InjectView(R.id.bt_notifications)
    Button btNotifications;
    @InjectView(R.id.rv_recycler_view)
    Button rvRecyclerView;
    @InjectView(R.id.rv_spring_view)
    Button rvSpringView;
    @InjectView(R.id.rv_auto_view_pager)
    Button rvAutoViewPager;


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
        btPath.setOnClickListener(this);
        btMvpLogin.setOnClickListener(this);
        btTakePhoto.setOnClickListener(this);

        btLayoutInflater.setOnClickListener(this);
        btPictureRotate.setOnClickListener(this);
        btMenu.setOnClickListener(this);

        btNotifications.setOnClickListener(this);
        rvRecyclerView.setOnClickListener(this);

        rvSpringView.setOnClickListener(this);
        rvAutoViewPager.setOnClickListener(this);
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
            case R.id.bt_path:
                intent = new Intent(mContext, PathActivity.class);

                startActivity(intent);
                break;
            case R.id.bt_mvp_login:
                intent = new Intent(mContext, UserLoginActivity.class);

                startActivity(intent);
                break;

            case R.id.bt_take_photo:
                intent = new Intent(mContext, PhotoActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_layout_inflater:
                intent = new Intent(mContext, LayoutInflaterActivity.class);

                startActivity(intent);
                break;
            case R.id.bt_picture_rotate:
                intent = new Intent(mContext, PictureRotateActivity.class);
                startActivity(intent);

                break;
            case R.id.bt_menu:
                intent = new Intent(mContext, MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_notifications:
                intent = new Intent(mContext, NotificationsActivity.class);

                startActivity(intent);
                break;

            case R.id.rv_recycler_view:
                intent = new Intent(mContext, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.rv_spring_view:
                intent = new Intent(mContext, SpringViewActivity.class);
                startActivity(intent);
                break;
            case R.id.rv_auto_view_pager:
                intent = new Intent(mContext, AutoViewpagerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
