package com.dxy.exercisecodefromblog.viewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dxy.exercisecodefromblog.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AutoViewpagerActivity extends AppCompatActivity {


    @InjectView(R.id.pv_pager_view)
    RollPagerView pvPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_viewpager);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {

        pvPagerView.setAdapter(new MyLoopAdapter(pvPagerView));

    }

    private class MyLoopAdapter extends LoopPagerAdapter{

        private int [] imgs = {R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d
        ,R.mipmap.e};

        public MyLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {

            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            return view;
        }

        @Override
        protected int getRealCount() {
            return  imgs.length;
        }
    }
}
