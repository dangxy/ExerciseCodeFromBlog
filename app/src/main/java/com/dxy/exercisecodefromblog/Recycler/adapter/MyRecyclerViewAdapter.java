package com.dxy.exercisecodefromblog.Recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by author_dang on 16/6/17.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.myRecyclerViewAdapter> {
    private LayoutInflater mLayoutInflater;

    private Context mContext;

    private String[] mTitles;

    private int[] mPictures;


    public MyRecyclerViewAdapter(Context context, String[] title, int[] pic) {

        this.mContext = context;
        this.mTitles = title;
        this.mPictures = pic;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public myRecyclerViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(myRecyclerViewAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class myRecyclerViewAdapter extends RecyclerView.ViewHolder {


        public myRecyclerViewAdapter(View itemView) {
            super(itemView);


        }
    }
}
