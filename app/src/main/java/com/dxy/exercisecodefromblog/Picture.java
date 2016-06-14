package com.dxy.exercisecodefromblog;

/**
 * Created by author_dang on 16/6/14.
 */
public class Picture {

    private String name;
    private int resourse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourse() {
        return resourse;
    }

    public void setResourse(int resourse) {
        this.resourse = resourse;
    }

    public Picture(String name, int resourse) {
        this.name = name;
        this.resourse = resourse;
    }
}
