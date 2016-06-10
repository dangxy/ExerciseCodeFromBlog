package com.dxy.exercisecodefromblog.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.dxy.exercisecodefromblog.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TakeCameraActivity extends AppCompatActivity {

    @InjectView(R.id.bt_take_picture)
    Button btTakePicture;

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    @InjectView(R.id.iv_image_view)
    ImageView ivImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_camera);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.bt_take_picture)
    public void onClick() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();

            Bitmap imageBitmap = (Bitmap) bundle.get("data");

            ivImageView.setImageBitmap(imageBitmap);


        }
    }
}
