package com.example.android21;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android21.db.MyDBHelper;

public class MainActivity extends AppCompatActivity {

    Button tbnCreateTable;
    Button tbnInputData;
    Button tbnRetrieveData;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("SQLite Practices");

        myDBHelper = new MyDBHelper( this );

        tbnCreateTable=(Button)findViewById(R.id.btnCreateTable);
        tbnCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlLite = myDBHelper.getWritableDatabase();
                String dropSQL="DROP TABLE if exists userTBL; ";
                sqlLite.execSQL(dropSQL);

                String sql ="CREATE TABLE userTBL("+
                        "id CHAR(20) PRIMARY KEY,"+
                        "name CHAR(20),"+
                        "email CHAR(50),"+
                        "birthyear INTEGER"+
                        ")";

                sqlLite.execSQL(sql);
                sqlLite.close();
            }
        });
        tbnInputData = (Button) findViewById(R.id.btnInputData);
        tbnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InputDataActivity.class);
                startActivity(intent);
            }
        });
        tbnRetrieveData=(Button) findViewById(R.id.btnRetrieveData);
        tbnRetrieveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RetrieveDataActivity.class);
                startActivity(intent);
            }
        });

    }
}