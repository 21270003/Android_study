package com.example.android18;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CustomListViewActivity extends AppCompatActivity {

    ListView lvData1;
    CustomListViewAdapter myAdapter;
    Button btnGoBack;
    Button btnAddItem1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);
        setTitle( "CustomListViewActivity" );

        myAdapter = new CustomListViewAdapter( );
        myAdapter.addOneItem(ContextCompat.getDrawable(this, R.drawable.a30fps_select_24dp),
                "ICON", "30fps_select_24dp");
        myAdapter.addOneItem(ContextCompat.getDrawable(this, R.drawable.award_star_24dp),
                "IMAGE", "award_star_24dp");
        lvData1 = (ListView) findViewById( R.id.lvData1 ) ;
        lvData1.setAdapter( myAdapter );

        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListOneData item = (ListOneData) parent.getItemAtPosition(position) ;
                String title = item.getTitle() ;
                String description = item.getDescription() ;
                Drawable icon = item.getIcon() ;
                Toast.makeText(CustomListViewActivity.this, title + " ::: "+description, Toast.LENGTH_SHORT).show();
            }
        });

        btnGoBack = (Button)  findViewById( R.id.btnGoBack ) ;
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAddItem1=(Button) findViewById( R.id.btnAddItem1 ) ;
        btnAddItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.addOneItem(ContextCompat.getDrawable( getApplicationContext(), R.drawable.landscape_2_24dp),
                        "ICON", "landscape_2_24dp");

            }
        });


    }
}