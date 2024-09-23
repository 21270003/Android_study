package com.example.android21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android21.db.UserEntity;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {
    ArrayList<UserEntity> dataList = new ArrayList<UserEntity>();
    @Override public int getCount() { return dataList.size(); }
    @Override public Object getItem(int position) { return dataList.get( position ); }
    @Override public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if( convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate( R.layout.layout_list_one_item, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById( R.id.tvName ) ;
        TextView tvEmail = (TextView) convertView.findViewById( R.id.tvEmail ) ;

        UserEntity item =dataList.get( position ) ;
        tvName.setText( item.getName() + "( " +item.getBirthyear()+ " )" );
        tvEmail.setText( item.getEmail() );
        return convertView;
    }

    public void addOneUser( String id, String name, String email, int birthyear ){
        UserEntity oneData = new UserEntity();
        oneData.setBirthyear( birthyear );
        oneData.setId( id );
        oneData.setEmail( email );
        oneData.setName( name );
        dataList.add( oneData );
    }
}
