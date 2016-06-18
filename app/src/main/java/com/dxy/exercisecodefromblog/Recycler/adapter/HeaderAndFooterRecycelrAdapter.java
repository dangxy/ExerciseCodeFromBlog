package com.dxy.exercisecodefromblog.Recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dxy.exercisecodefromblog.R;

/**
 * Created by author_dang on 16/6/18.
 */
public class HeaderAndFooterRecycelrAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;
    //模拟数据
    public String[] texts = {"高圆圆", "刘亦菲",
            "刘涛",
            "郭碧婷",
            "范冰冰",
            "汤唯",
            "周迅",
            "唐嫣",
            "刘诗诗",
            "Angelababy", "郭碧婷",
            "范冰冰",
            "汤唯",
            "周迅",
            "唐嫣",
            "刘诗诗",
            "Angelababy"};
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mHeaderCount = 1;//头部View个数
    private int mBottomCount = 1;//底部View个数


    public HeaderAndFooterRecycelrAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);

    }

    /**
     * 获取内容的长度
     */

    public int getContentItemCount() {
        return texts.length;

    }

    public boolean isItemHeader(int position){
        return mHeaderCount!=0&&position<mHeaderCount;
    }

    public boolean isItemFooter(int position){
        return mBottomCount!=0&& position>= (mHeaderCount+getContentItemCount());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderRecyclerViewHolder(mLayoutInflater.inflate(R.layout.header, parent, false));
        } else if (viewType == ITEM_TYPE_CONTENT) {
            return new ContentRecyclerViewHolder(mLayoutInflater.inflate(R.layout.content, parent, false));
        } else {
            return new FooterRecyclerViewHolder(mLayoutInflater.inflate(R.layout.footer, parent, false));
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof ContentRecyclerViewHolder) {
            ((ContentRecyclerViewHolder) holder).textView.setText(texts[position-mHeaderCount]);
        } else if (holder instanceof HeaderRecyclerViewHolder) {

        } else if (holder instanceof FooterRecyclerViewHolder) {

        }

    }

    @Override
    public int getItemCount() {
        return mBottomCount + mHeaderCount + getContentItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        int contentItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;
        } else if (mBottomCount != 0 && position >= (mHeaderCount + contentItemCount)) {
            return ITEM_TYPE_BOTTOM;
        } else {
            return ITEM_TYPE_CONTENT;
        }


    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public static class HeaderRecyclerViewHolder extends RecyclerView.ViewHolder {

        public HeaderRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ContentRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ContentRecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item_content);
        }
    }

    public static class FooterRecyclerViewHolder extends RecyclerView.ViewHolder {
        public FooterRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
