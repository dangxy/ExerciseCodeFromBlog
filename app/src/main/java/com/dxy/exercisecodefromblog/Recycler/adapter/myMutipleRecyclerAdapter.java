package com.dxy.exercisecodefromblog.Recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dxy.exercisecodefromblog.R;

/**
 * Created by author_dang on 16/6/17.
 */
public class myMutipleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;

    private LayoutInflater layoutInflater;


    private String [] titles;

    public myMutipleRecyclerAdapter(Context mContext, String[] titles) {
        this.mContext = mContext;
        this.titles = titles;
        layoutInflater= LayoutInflater.from(mContext);
    }

    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }


    @Override
    public int getItemViewType(int position) {
        return position%2==0?ITEM_TYPE.ITEM1.ordinal():ITEM_TYPE.ITEM2.ordinal();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof firstItemTypeViewHolder){

            ((firstItemTypeViewHolder) holder).firstTextView.setText(titles[position]);
        }else if(holder instanceof secondItemTypeViewHolder){
            ((secondItemTypeViewHolder) holder).secondTextView.setText(titles[position]);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_TYPE.ITEM1.ordinal()){


            return  new firstItemTypeViewHolder(layoutInflater.inflate( R.layout.item_first_recycler_view_layout,parent,false));

        } else if(viewType==ITEM_TYPE.ITEM2.ordinal()){

            return new secondItemTypeViewHolder(layoutInflater.inflate(R.layout.item_second_recycler_view_layout,parent,false));

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return titles==null?0:titles.length;
    }

    public static class firstItemTypeViewHolder  extends RecyclerView.ViewHolder{

        private TextView firstTextView;

        public firstItemTypeViewHolder(View itemView) {
            super(itemView);

            firstTextView = (TextView)itemView.findViewById(R.id.tv_item1_text);
        }
    }

    public static class secondItemTypeViewHolder extends RecyclerView.ViewHolder{

        private TextView secondTextView;
        public secondItemTypeViewHolder(View itemView) {
            super(itemView);

            secondTextView = (TextView)itemView.findViewById(R.id.tv_item2_text);
        }
    }
}
