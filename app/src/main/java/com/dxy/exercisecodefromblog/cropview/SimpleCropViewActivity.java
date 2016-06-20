package com.dxy.exercisecodefromblog.cropview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dxy.exercisecodefromblog.R;
import com.isseiaoki.simplecropview.CropImageView;
import com.isseiaoki.simplecropview.callback.CropCallback;
import com.isseiaoki.simplecropview.callback.LoadCallback;
import com.isseiaoki.simplecropview.callback.SaveCallback;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SimpleCropViewActivity extends AppCompatActivity {

    public static final int IMAGE_CODE = 2;
    @InjectView(R.id.bt_get_uri)
    Button btGetUri;
    @InjectView(R.id.cropImageView)
    CropImageView cropImageView;
    @InjectView(R.id.bt_save)
    Button btSave;
    @InjectView(R.id.bt_find_all)
    Button btFindAll;
    @InjectView(R.id.iv_result)
    ImageView ivResult;

    private Uri originalUri;


    public SimpleCropViewActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_crop_view);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {

        btGetUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_CODE);

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath(), "dang"));
                cropImageView.startCrop(uri, new CropCallback() {
                    @Override
                    public void onSuccess(Bitmap cropped) {

                        ivResult.setImageBitmap(cropped);
                    }

                    @Override
                    public void onError() {

                    }
                }, new SaveCallback() {
                    @Override
                    public void onSuccess(Uri outputUri) {

                        Toast.makeText(getApplicationContext(), outputUri + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {

                    }
                });
            }
        });

        btFindAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                    startActivityForResult(new Intent(Intent.ACTION_GET_CONTENT).setType("image/*"), 1001);
                } else {
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("image/*");
                    startActivityForResult(intent, 1002);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == IMAGE_CODE) {

            originalUri = data.getData();
            Toast.makeText(getApplicationContext(), originalUri + "", Toast.LENGTH_SHORT).show();
            cropImageView.setImageURI(originalUri);
            if (originalUri != null) {
                cropImageView.startLoad(originalUri, new LoadCallback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), originalUri + "图片加载成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getApplicationContext(), "图片加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if(requestCode==1001){
            originalUri = data.getData();
            Toast.makeText(getApplicationContext(), originalUri + "", Toast.LENGTH_SHORT).show();
            cropImageView.setImageURI(originalUri);
            if (originalUri != null) {
                cropImageView.startLoad(originalUri, new LoadCallback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });
            }


        }else if(requestCode==1002){
            originalUri = data.getData();
            Toast.makeText(getApplicationContext(), originalUri + "", Toast.LENGTH_SHORT).show();
            cropImageView.setImageURI(originalUri);
            if (originalUri != null) {
                cropImageView.startLoad(originalUri, new LoadCallback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });
            }


        }
    }


}
