package com.dxy.exercisecodefromblog.takephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dxy.exercisecodefromblog.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener{

    @InjectView(R.id.take_photo_camera)
    Button takePhotoCamera;
    @InjectView(R.id.take_photo_tu_ku)
    Button takePhotoTuKu;

    private Uri imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.inject(this);

        initData();
    }

    private void initData(){
        takePhotoCamera.setOnClickListener(this);

        takePhotoTuKu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.take_photo_camera:

              if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
                  File sdcardDir = Environment.getExternalStorageDirectory();
                  String path = sdcardDir.getPath()+"/cardImages";

                  File photofile = new File(path);

                  if(!photofile.exists()){
                      photofile.mkdirs();
                  }else{
                      imageUrl =   Uri.fromFile(new File(photofile,getHeadPictureName()));

                      Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                      intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                      intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUrl);
                      startActivityForResult(intent,1);
                  }

              }






                break;

            case R.id.take_photo_tu_ku:
                break;

        }
    }

    public String getHeadPictureName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent("com.android.camera.action.CROP");

        Uri uri = null;

        if(data==null){
            uri=imageUrl;
        }else{
            uri= data.getData();
        }
        if(resultCode==RESULT_OK){

            switch (requestCode){
                case 1:
                    intent.setDataAndType(uri,"image/*");

                    intent.putExtra("crop",true);
                    intent.putExtra("aspectX", 1);
                    intent.putExtra("aspectY", 1);
                    intent.putExtra("outputX", 320);
                    intent.putExtra("outputY", 320);
                    intent.putExtra("return-data", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(intent, 3);

                    break;
                case 3:
                    if(data!=null){
                        Intent resultIntent = getIntent();

                        Bundle bundle = data.getExtras();
                        Bitmap myBitmap = bundle.getParcelable("data");

                        resultIntent.putExtra("myBitmap",myBitmap);

                        setResult(1,resultIntent);

                        finish();
                    }
                    break;
            }
        }
    }
}
