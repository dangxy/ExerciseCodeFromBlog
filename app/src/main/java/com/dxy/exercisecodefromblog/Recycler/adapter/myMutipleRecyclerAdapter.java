package com.dxy.exercisecodefromblog.Recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by author_dang on 16/6/17.
 */
public class myMutipleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_TYPE.ITEM1.ordinal()){


        } else if(viewType==ITEM_TYPE.ITEM2.ordinal()){

        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class firstItemTypeViewHolder  extends RecyclerView.ViewHolder{

        public firstItemTypeViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class secondItemTypeViewHolder extends RecyclerView.ViewHolder{
        public secondItemTypeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
