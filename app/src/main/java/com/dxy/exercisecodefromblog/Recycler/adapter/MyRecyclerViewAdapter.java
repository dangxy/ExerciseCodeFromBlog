package com.dxy.exercisecodefromblog.Recycler.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dxy.exercisecodefromblog.R;

import java.util.ArrayList;

/**
 * Created by author_dang on 16/6/17.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;

    private Context mContext;

    private ArrayList<String> mTitles;



    public MyRecyclerViewAdapter(Context context, ArrayList<String> title) {

        this.mContext = context;
        this.mTitles = title;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myRecyclerViewAdapterViewHolder(mLayoutInflater.inflate(R.layout.item_recycler_view_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof myRecyclerViewAdapterViewHolder) {

            ((myRecyclerViewAdapterViewHolder)holder).imageView.setImageResource(R.mipmap.a);

            ((myRecyclerViewAdapterViewHolder)holder).textView.setText(mTitles.get(position));

            ((myRecyclerViewAdapterViewHolder)holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.size();
    }

    public static class myRecyclerViewAdapterViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        private ImageView imageView;

        private TextView textView;

        public myRecyclerViewAdapterViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cv_item);
            textView = (TextView) itemView.findViewById(R.id.tv_text);
            imageView = (ImageView) itemView.findViewById(R.id.iv_pic);


        }
    }
}
