package com.dxy.exercisecodefromblog.mvp.bean.view;

import com.dxy.exercisecodefromblog.mvp.bean.User;

/**
 * Created by author_dang on 16/6/12.
 */
public interface IUserLoginView {

    String getUserName();

    String getpassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
