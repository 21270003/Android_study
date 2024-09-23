package com.example.android22;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Switch switch1;
    MediaPlayer mPlayer=null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle( "play music...." );

        mPlayer=MediaPlayer.create( this, R.raw.song3 );
        switch1 = (Switch)  findViewById( R.id.switch1 ) ;
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if( switch1.isChecked() == true ){
                    mPlayer.start();
                    Toast.makeText(MainActivity.this, " Play.....", Toast.LENGTH_SHORT).show();
                } else{
                    mPlayer.stop();
                }
            }
        });

    }
}