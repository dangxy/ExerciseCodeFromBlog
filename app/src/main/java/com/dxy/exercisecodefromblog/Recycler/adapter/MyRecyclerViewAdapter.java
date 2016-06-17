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

/**
 * Created by author_dang on 16/6/17.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.myRecyclerViewAdapterViewHolder> {
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
    public myRecyclerViewAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myRecyclerViewAdapterViewHolder(mLayoutInflater.inflate(R.layout.item_recycler_view_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(myRecyclerViewAdapterViewHolder holder, final int position) {

        holder.imageView.setImageResource(mPictures[position]);

        holder.textView.setText(mTitles[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
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
