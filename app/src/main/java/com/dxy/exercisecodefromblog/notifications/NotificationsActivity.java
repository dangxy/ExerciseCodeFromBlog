package com.dxy.exercisecodefromblog.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.dxy.exercisecodefromblog.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NotificationsActivity extends AppCompatActivity {

    @InjectView(R.id.bt_send)
    Button btSend;
    @InjectView(R.id.bt_cancel)
    Button btCancel;
    @InjectView(R.id.cb_check_box)
    CheckBox cbCheckBox;


    private NotificationManager mNotificationManager;

    private Notification mNotification;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.inject(this);
        mContext = this;
        initData();
    }

    private void initData() {


        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);

                mNotification = builder.setContentTitle("这是通知的标题栏").setContentText("通知的内容").setWhen(System.currentTimeMillis()).setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).build();

                mNotification.defaults = Notification.DEFAULT_SOUND;

                mNotificationManager = (NotificationManager) NotificationsActivity.this.getSystemService(NOTIFICATION_SERVICE);


                Intent intent = new Intent(mContext, NotificationsActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                PendingIntent mContentIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

                builder.setContentIntent(mContentIntent);
                mNotificationManager.notify(0, mNotification);

            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificationManager.cancel(0);
            }
        });


        cbCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cbCheckBox.setChecked(!cbCheckBox.isChecked());
            }
        });


    }
}
