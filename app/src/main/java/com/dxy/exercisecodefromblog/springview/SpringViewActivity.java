package com.dxy.exercisecodefromblog.springview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.exercisecodefromblog.R;
import com.liaoinstan.springview.widget.SpringView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SpringViewActivity extends AppCompatActivity {

    @InjectView(R.id.rv_spring_view_recycler_view)
    RecyclerView rvSpringViewRecyclerView;
    @InjectView(R.id.sv_spring_view)
    SpringView svSpringView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_view);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {


    }


    private class SpringViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class SpringViewViewHolder extends RecyclerView.ViewHolder {
            public SpringViewViewHolder(View itemView) {
                super(itemView);
            }
        }
    }


}

