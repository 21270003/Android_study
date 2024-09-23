package com.example.android18;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAddItem;
    Button btnGoNext;
    ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        final String[] titleDatas={"빅뱅이론", "미녀와 순정남", "왕좌의 게임", "도깨비" };



        SimpleAdapter  myAdapter = new  SimpleAdapter();

        lvData= (ListView)  findViewById( R.id.lvData ) ;
        lvData.setAdapter(  myAdapter ) ;

        myAdapter.addItem("빅뱅이론");

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected:" + titleDatas[position], Toast.LENGTH_SHORT).show();
            }
        });



        btnAddItem = (Button)  findViewById( R.id.btnAddItem ) ;
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.addItem("미녀와 순정남");
            }
        });
        btnGoNext=(Button) findViewById( R.id.btnGoNext ) ;
        btnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), CustomListViewActivity.class) ;
                startActivity( intent );
            }
        });
    }
}