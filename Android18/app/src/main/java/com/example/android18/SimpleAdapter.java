package com.example.android18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleAdapter  extends BaseAdapter {
    ArrayList<String> itemDatas = new  ArrayList<String>();
    @Override
    public int getCount() {
        return itemDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return  itemDatas.get(  position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View curView, ViewGroup parent) {
        final Context context = parent.getContext();
        if (curView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            curView = inflater.inflate( R.layout.layout_list_item, parent, false);
        }
        TextView tvItem = (TextView) curView.findViewById(R.id.tvItem) ;

        String displayData = itemDatas.get( position ) ;

        tvItem.setText(  displayData );
        return curView;
    }

    public void addItem( String addData ){
        itemDatas.add(  addData );
        this.notifyDataSetChanged();
    }

}
