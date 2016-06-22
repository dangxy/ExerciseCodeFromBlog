package com.dxy.exercisecodefromblog.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.exercisecodefromblog.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AutoViewpagerActivity extends AppCompatActivity {


    @InjectView(R.id.pv_pager_view)
    RollPagerView pvPagerView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_viewpager);
        ButterKnife.inject(this);

        mContext = this;
        initData();
    }

    private void initData() {

        pvPagerView.setAdapter(new MyLoopAdapter(pvPagerView, mContext));

    }

    private class MyLoopAdapter extends LoopPagerAdapter {

        private Context context;

        public MyLoopAdapter(RollPagerView viewPager, Context context) {
            super(viewPager);
            this.context = context;
        }

        private int[] imgs = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d
                , R.mipmap.e};

        public MyLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {

//            ImageView view = new ImageView(container.getContext());
//            view.setImageResource(imgs[position]);
//            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            View view = getLayoutInflater().inflate(R.layout.layout_auto_list_view, null);

            GridView gridView = (GridView) view.findViewById(R.id.grid_view);

            ArrayList imageArrayList = new ArrayList();
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);
            imageArrayList.add(R.mipmap.car);

            ArrayList<String> nameArrayList = new ArrayList<>();

            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");
            nameArrayList.add("车");

            gridView.setAdapter(new myGridViewAdAdapter(imageArrayList,nameArrayList,mContext));


            return view;
        }

        @Override
        protected int getRealCount() {
            return 3;
        }
    }

    private class myGridViewAdAdapter extends BaseAdapter {

        private ArrayList<Integer> imageArrayList;

        private ArrayList<String> nameArrayList;

        private LayoutInflater layoutInflater;

        public myGridViewAdAdapter(ArrayList<Integer> imageArrayList, ArrayList<String> nameArrayList, Context context) {
            this.imageArrayList = imageArrayList;
            this.nameArrayList = nameArrayList;

            layoutInflater = LayoutInflater.from(context);


        }

        @Override
        public int getCount() {
            return imageArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return imageArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            System.out.println("getView " + position + " " + convertView);
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_grid_view, null);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.tv_name);
                holder.imageView = (ImageView) convertView.findViewById(R.id.iv_type);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(nameArrayList.get(position));
            holder.imageView.setBackgroundResource(imageArrayList.get(position));
            return convertView;
        }

    }

    public static class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }
}

