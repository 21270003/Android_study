package com.example.android21;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android21.db.MyDBHelper;

public class InputDataActivity extends AppCompatActivity {

    Button tbnClose;
    Button tbnSave;
    MyDBHelper myDBHelper ;
    SQLiteDatabase sqlLite;
    EditText etId ;
    EditText etName ;
    EditText etEmail ;
    EditText etBirthyear ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);
        setTitle(" New User ..." ) ;

        etId =(EditText) findViewById( R.id.etId );
        etName =(EditText) findViewById( R.id.etName );
        etEmail =  (EditText) findViewById( R.id.etEmail );
        etBirthyear = (EditText) findViewById( R.id.etBirthyear );

        myDBHelper = new MyDBHelper( this ) ;

        tbnClose = (Button)  findViewById( R.id.tbnClose );
        tbnClose.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });

        tbnSave= (Button)  findViewById( R.id.tbnSave ) ;
        tbnSave.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View v) {
                String sql = "INSERT INTO userTBL (  "+
                        "id ,  name, email, birthyear  " +
                        " ) VALUES (   " +
                        " '"+etId.getText().toString()+"',  '"+etName.getText().toString()+"', '"+etEmail.getText().toString()+"' , '"+etBirthyear.getText().toString()+"'  " +
                        " )  ;"   ;
                sqlLite=myDBHelper.getWritableDatabase( );
                sqlLite.execSQL( sql );
                sqlLite.close();

                etId.setText("");
                etName.setText("");
                etEmail.setText("");
                etBirthyear.setText("");

            }
        });
    }
}