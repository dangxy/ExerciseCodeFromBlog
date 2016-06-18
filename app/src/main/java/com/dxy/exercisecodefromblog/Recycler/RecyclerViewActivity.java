package com.dxy.exercisecodefromblog.Recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dxy.exercisecodefromblog.R;
import com.dxy.exercisecodefromblog.Recycler.adapter.HeaderAndFooterRecycelrAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerViewActivity extends AppCompatActivity {

    @InjectView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;

    private Context mContext;

    private HeaderAndFooterRecycelrAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.inject(this);
        mContext = this;
        initData();
    }

    private void initData() {
        int[] pic = new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e};

        String[] title = new String[]{"美女1", "美女2", "美女3", "美女4", "美女5","美女1", "美女2", "美女3", "美女4", "美女5","美女1", "美女2", "美女3", "美女4", "美女5"};


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        rvRecyclerView.setLayoutManager(gridLayoutManager);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                return adapter.isItemFooter(position)||adapter.isItemHeader(position)?gridLayoutManager.getSpanCount():1;
            }
        });

        //rvRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        //rvRecyclerView.setLayoutManager(linearLayoutManager);

       // rvRecyclerView.setAdapter(new myMutipleRecyclerAdapter(mContext,title));

        rvRecyclerView.setAdapter(adapter = new HeaderAndFooterRecycelrAdapter(mContext));


    }
}
