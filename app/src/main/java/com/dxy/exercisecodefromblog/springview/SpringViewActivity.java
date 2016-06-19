package com.dxy.exercisecodefromblog.springview;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dxy.exercisecodefromblog.R;
import com.liaoinstan.springview.container.AliFooter;
import com.liaoinstan.springview.container.AliHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SpringViewActivity extends AppCompatActivity {

    @InjectView(R.id.rv_spring_view_recycler_view)
    RecyclerView rvSpringViewRecyclerView;
    @InjectView(R.id.sv_spring_view)
    SpringView svSpringView;

    private ArrayList<String> mDatas = new ArrayList<>();

    private Context mContext;

    private SpringViewRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_view);
        ButterKnife.inject(this);
        initData();


        mContext = this;
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {

            mDatas.add(i + "data");


        }
        adapter = new SpringViewRecyclerAdapter(mContext);
        rvSpringViewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvSpringViewRecyclerView.setAdapter(adapter);

        svSpringView.setType(SpringView.Type.FOLLOW);
        svSpringView.setHeader(new AliHeader(this,R.mipmap.ali,true));

        svSpringView.setFooter(new AliFooter(this,false));

        svSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDatas.add(0,"instert data");
                        adapter.notifyDataSetChanged();
                        svSpringView.onFinishFreshAndLoad();

                    }
                },1000);
            }

            @Override
            public void onLoadmore() {

               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       mDatas.add("load more");
                       adapter.notifyDataSetChanged();
                       svSpringView.onFinishFreshAndLoad();

                   }
               },1000);

            }
        });



    }


    private class SpringViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private Context mContext;



        public SpringViewRecyclerAdapter(Context context) {
            this.mContext = context;

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            return new SpringViewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((SpringViewViewHolder) holder).textView.setText(mDatas.get(position));
            if (position % 2 == 0) {
                ((SpringViewViewHolder) holder).textView.setBackgroundColor(Color.parseColor("#e3f1fc"));
                ((SpringViewViewHolder) holder).textView.setTextColor(Color.parseColor("#9dd2fc"));
            } else {
                ((SpringViewViewHolder) holder).textView.setBackgroundColor(Color.parseColor("#ffffff"));
                ((SpringViewViewHolder) holder).textView.setTextColor(Color.parseColor("#cccccc"));
            }

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public class SpringViewViewHolder extends RecyclerView.ViewHolder {

            private TextView textView;

            public SpringViewViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.item_text);
            }
        }
    }


}

