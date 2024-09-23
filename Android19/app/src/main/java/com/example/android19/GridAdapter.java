package com.example.android19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    ArrayList<Integer> posterDatas = new ArrayList<Integer>();
    @Override public int getCount() {
        return posterDatas.size();
    }
    @Override public Object getItem(int position) {
        return posterDatas.get( position );
    }
    @Override public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if( convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate( R.layout.layout_grid_one_item, parent, false);
        }
        ImageView ivOnePoster = (ImageView) convertView.findViewById( R.id.ivOnePoster ) ;
        Integer curData = (Integer) this.getItem( position );
        ivOnePoster.setImageResource( curData );
        return convertView;
    }

    public void addOneItem( Integer posterID ){
        posterDatas.add( posterID );
    }

}
