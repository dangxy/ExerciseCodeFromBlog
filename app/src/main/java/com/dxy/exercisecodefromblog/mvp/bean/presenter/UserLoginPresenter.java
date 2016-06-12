package com.dxy.exercisecodefromblog.mvp.bean.presenter;

import android.os.Handler;

import com.dxy.exercisecodefromblog.mvp.bean.User;
import com.dxy.exercisecodefromblog.mvp.bean.biz.IUserBiz;
import com.dxy.exercisecodefromblog.mvp.bean.biz.OnLoginListener;
import com.dxy.exercisecodefromblog.mvp.bean.biz.UserBiz;
import com.dxy.exercisecodefromblog.mvp.bean.view.IUserLoginView;

/**
 * Created by author_dang on 16/6/12.
 */
public class UserLoginPresenter {

    private IUserBiz  userBiz;

    private IUserLoginView userLoginView;

    private Handler mHandler = new Handler();


    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;

        this.userBiz  = new UserBiz();
    }

    public void login(){

        userLoginView.showLoading();

        userBiz.login(userLoginView.getUserName(), userLoginView.getpassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);

                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void LoginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();

                        userLoginView.hideLoading();

                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
