package com.dxy.exercisecodefromblog.mvp.bean.biz;

import com.dxy.exercisecodefromblog.mvp.bean.User;

/**
 * Created by author_dang on 16/6/12.
 */
public class UserBiz implements  IUserBiz {
    @Override
    public void login(final String username, final  String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }


                if("dxy".equals(username)&&"123".equals(password)){
                    User user = new User();
                    user.setUsername(username);

                    user.setPassword(password);

                    loginListener.loginSuccess(user);

                }else{
                    loginListener.LoginFailed();
                }
            }
        }.start();
    }
}
