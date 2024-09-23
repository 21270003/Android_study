package com.example.android20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {
    Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
    } ;

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return posterID[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if( convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate( R.layout.layout_gallery_one_item, parent, false);
        }
        ImageView ivOnePoster = (ImageView) convertView.findViewById( R.id.ivOnePoster ) ;
        Integer curData = posterID[ position ] ;
        ivOnePoster.setImageResource( curData );
        return convertView;
    }
}