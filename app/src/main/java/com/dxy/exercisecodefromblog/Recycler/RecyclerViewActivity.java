package com.dxy.exercisecodefromblog.Recycler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.dxy.exercisecodefromblog.R;
import com.dxy.exercisecodefromblog.Recycler.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerViewActivity extends AppCompatActivity {

    @InjectView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;

    private Context mContext;

    private MyRecyclerViewAdapter adapter;

    private RecyclerAdapterWithHF madapter;


    private PtrClassicFrameLayout ptrClassicFrameLayout;


    private ArrayList<String> content = new ArrayList<>();

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

        final String[] title = new String[]{"美女1", "美女2", "美女3", "美女4", "美女5", "美女1", "美女2", "美女3", "美女4", "美女5", "美女1", "美女2", "美女3", "美女4", "美女5"};


        content.add("高圆圆");
        content.add("刘亦菲");
        content.add("刘涛");
        content.add("郭碧婷");
        content.add("范冰冰");
        content.add("汤唯");
        content.add("周迅");
        content.add("唐嫣");
        content.add("刘诗诗");
        content.add("Angelababy");
        content.add("郭碧婷");
        content.add("范冰冰");
        content.add("汤唯");
        content.add("周迅");
        content.add("唐嫣");
        content.add("刘诗诗");
        content.add("Angelababy");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

//        final GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
//        rvRecyclerView.setLayoutManager(gridLayoutManager);
//
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
//            @Override
//            public int getSpanSize(int position) {
//                return adapter.isItemFooter(position)||adapter.isItemHeader(position)?gridLayoutManager.getSpanCount():1;
//            }
//        });

        //rvRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        rvRecyclerView.setLayoutManager(linearLayoutManager);

        // rvRecyclerView.setAdapter(new myMutipleRecyclerAdapter(mContext,title));



        adapter = new MyRecyclerViewAdapter(mContext, content);
        madapter = new RecyclerAdapterWithHF(adapter);

        rvRecyclerView.setAdapter(madapter);

        ptrClassicFrameLayout = (PtrClassicFrameLayout) findViewById(R.id.rotate_header_list_view_frame);

        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);


        ptrClassicFrameLayout.setResistance(1.7f);

        ptrClassicFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);

        ptrClassicFrameLayout.setDurationToClose(200);
        ptrClassicFrameLayout.setDurationToCloseHeader(1000);

        ptrClassicFrameLayout.setPullToRefresh(false);

        ptrClassicFrameLayout.setKeepHeaderWhenRefresh(true);


        ptrClassicFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {


                ptrClassicFrameLayout.autoRefresh();
            }
        }, 100);


        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {


            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                for (int i = 0; i < 5; i++) {
                    content.add(0,"高圆圆"+i);
                }

                new Handler
                        ().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        madapter.notifyDataSetChanged();

                        ptrClassicFrameLayout.refreshComplete();

                        ptrClassicFrameLayout.setLoadMoreEnable(true);

                    }
                }, 1000);
            }
        });

        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            content.add("唐嫣" + i);
                        }


                        madapter.notifyDataSetChanged();

                        ptrClassicFrameLayout.refreshComplete();
                        Toast.makeText(RecyclerViewActivity.this, "load more complete", Toast.LENGTH_SHORT)
                                .show();

                        ptrClassicFrameLayout.setLoadMoreEnable(false);
                    }
                }, 1000);
            }
        });

    }
}
