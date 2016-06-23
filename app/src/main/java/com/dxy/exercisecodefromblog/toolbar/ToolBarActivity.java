package com.dxy.exercisecodefromblog.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dxy.exercisecodefromblog.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ToolBarActivity extends AppCompatActivity {

    @InjectView(R.id.tb_tool_bar)
    Toolbar tbToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.inject(this);
        initData();
    }

    private void initData(){

        tbToolBar.setLogo(R.mipmap.icon_24);

        tbToolBar.setTitle("Save money");
        tbToolBar.setSubtitle("++");

        setSupportActionBar(tbToolBar);

        tbToolBar.setNavigationIcon(R.mipmap.icon_navigation_view_small);

    }
}
