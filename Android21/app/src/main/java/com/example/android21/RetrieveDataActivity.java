package com.example.android21;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android21.db.MyDBHelper;
import com.example.android21.db.UserEntity;

public class RetrieveDataActivity extends AppCompatActivity {

    UserListAdapter myAdapter;
    ListView lvUserList;
    Button tbnGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_retrieve_data);
        setTitle(" User List...") ;

        tbnGoBack=(Button) findViewById( R.id.tbnGoBack );
        tbnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });


        myAdapter = new  UserListAdapter( );
        addDatasFromSQLite( myAdapter, this );

        lvUserList = (ListView) findViewById( R.id.lvUserList );
        lvUserList.setAdapter( myAdapter );
        lvUserList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserEntity selectedData = (UserEntity)parent.getItemAtPosition( position );

                View dialogView = (View) View.inflate( RetrieveDataActivity.this, R.layout.layout_user_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder( RetrieveDataActivity.this);

                TextView tvId = (TextView) dialogView.findViewById(R.id.tvId);
                TextView tvEmail = (TextView) dialogView.findViewById(R.id.tvEmail);
                TextView tvBirthyear = (TextView) dialogView.findViewById(R.id.tvBirthyear);

                tvId.setText( selectedData.getId() );
                tvEmail.setText( selectedData.getEmail() );
                tvBirthyear.setText( Integer.toString( selectedData.getBirthyear() ) );

                dlg.setTitle( selectedData.getName() );
                dlg.setIcon( R.mipmap.ic_launcher );
                dlg.setView(dialogView);
                dlg.setNegativeButton("[Close]", null);
                dlg.show();
            }
        });

    }


    private void addDatasFromSQLite( UserListAdapter myAdapter, Context context ){
        MyDBHelper myDBHelper = new  MyDBHelper( context );
        SQLiteDatabase sqlLite = myDBHelper.getWritableDatabase( ) ;
        Cursor cursor = sqlLite.rawQuery("SELECT * FROM userTBL;", null  ) ;

        while( cursor.moveToNext()){

            String id = cursor.getString(0 ) ;
            String name = cursor.getString(1 ) ;
            String email = cursor.getString(2 ) ;
            int birthyear =cursor.getInt( 3 ) ;

            myAdapter.addOneUser( id, name, email, birthyear );

        }
        cursor.close();
        sqlLite.close();
    }

}