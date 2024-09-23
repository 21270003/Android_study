package com.example.android20;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Gallery movieGallery;
    ImageView ivPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ivPoster = (ImageView) findViewById( R.id.ivPoster ) ;
        MyGalleryAdapter myAdapter = new MyGalleryAdapter();
        movieGallery = (Gallery) findViewById( R.id.movieGallery ) ;
        movieGallery.setAdapter( myAdapter );

        movieGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer posterID = (Integer) parent.getItemAtPosition(position) ;
                ivPoster.setImageResource( posterID ) ;
            }
        });


    }
}