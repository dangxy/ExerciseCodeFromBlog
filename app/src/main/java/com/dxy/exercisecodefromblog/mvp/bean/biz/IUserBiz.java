package com.dxy.exercisecodefromblog.mvp.bean.biz;

/**
 * Created by author_dang on 16/6/12.
 */
public interface IUserBiz  {

    public void login(String username,String password,OnLoginListener onLoginListener);
}
