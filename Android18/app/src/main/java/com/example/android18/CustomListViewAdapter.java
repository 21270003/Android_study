package com.example.android18;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {
    ArrayList<ListOneData> itemDatas = new  ArrayList<ListOneData>();

    @Override
    public int getCount() {
        return  itemDatas.size() ;
    }
    @Override
    public Object getItem(int position) {
        return itemDatas.get( position );
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
            convertView = inflater.inflate( R.layout.layout_one_item, parent, false);
        }

        ImageView ivICon = (ImageView) convertView.findViewById( R.id.ivICon ) ;
        TextView  tvTitle = (TextView)  convertView.findViewById( R.id.tvTitle ) ;
        TextView tvDescription=(TextView)  convertView.findViewById( R.id.tvDescription  ) ;

        //ListOneData curData =itemDatas.get( position );
        ListOneData curData = (ListOneData) this.getItem( position );

        tvTitle.setText(  curData.getTitle() );
        tvDescription.setText( curData.getDescription() );
        ivICon.setImageDrawable(  curData.getIcon() );

        return convertView;
    }


    public void addOneItem(Drawable icon, String title, String description){
        ListOneData oneData = new ListOneData();
        oneData.setDescription( description );
        oneData.setTitle( title );
        oneData.setIcon( icon );
        itemDatas.add( oneData ) ;
        this.notifyDataSetChanged( ) ;
    }
}
