package com.dxy.exercisecodefromblog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dxy.exercisecodefromblog.Picture;

import java.util.List;

/**
 * Created by author_dang on 16/6/14.
 */
public class PictureAdapter extends ArrayAdapter<Picture> {
    public PictureAdapter(Context context, int resource, List<Picture> objects) {
        super(context, resource, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Picture picture = getItem(position);

        View view;

        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1,null);


        }else{
            view = convertView;
        }

        TextView text1 = (TextView)view.findViewById(android.R.id.text1);
        text1.setText(picture.getName());
        return view;

    }
}
