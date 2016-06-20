package com.dxy.exercisecodefromblog.cropview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.exercisecodefromblog.R;

public class SimpleCropViewFragment extends Fragment {



    public SimpleCropViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_simple_crop_view, container, false);
    }





}
