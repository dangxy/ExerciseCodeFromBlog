package com.dxy.exercisecodefromblog.mvp.bean.biz;

import com.dxy.exercisecodefromblog.mvp.bean.User;

/**
 * Created by author_dang on 16/6/12.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void LoginFailed();
}
