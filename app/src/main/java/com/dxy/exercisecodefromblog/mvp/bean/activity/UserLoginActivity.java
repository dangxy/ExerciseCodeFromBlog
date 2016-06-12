package com.dxy.exercisecodefromblog.mvp.bean.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dxy.exercisecodefromblog.R;
import com.dxy.exercisecodefromblog.mvp.bean.User;
import com.dxy.exercisecodefromblog.mvp.bean.presenter.UserLoginPresenter;
import com.dxy.exercisecodefromblog.mvp.bean.view.IUserLoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.bt_login)
    Button btLogin;
    @InjectView(R.id.bt_clear)
    Button btClear;
    @InjectView(R.id.pb_login)
    ProgressBar pbLogin;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.inject(this);

        initView();

    }

    private  void initView(){
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });
    }


    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getpassword() {
        return etPassword.getText().toString();
    }


    @Override
    public void clearUserName() {

        etUsername.setText("");

    }

    @Override
    public void clearPassword() {

        etPassword.setText("");
    }

    @Override
    public void showLoading() {

        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        pbLogin.setVisibility(View.GONE);

    }

    @Override
    public void toMainActivity(User user) {

        Toast.makeText(this,user.getUsername()+"   login success ",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {

        Toast.makeText(this,"login failed ",Toast.LENGTH_SHORT).show();

    }
}
