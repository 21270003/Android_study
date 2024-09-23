package com.pipa.android17;

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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int AddCount =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView lvList ;
        final CustomListViewAdapter adapter;

        // Adapter 생성
        adapter = new CustomListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        lvList = (ListView) findViewById(R.id.lvList);
        lvList.setAdapter(adapter);

        // icon download:::: https://fonts.google.com/icons
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.a30fps_select_24dp),
                "ICON", "30fps_select_24dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.award_star_24dp),
                "ICON", "award_star_24dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.brightness_7_24dp),
                "ICON", "brightness_7_24dp") ;


        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                // get item
                ListItem item = (ListItem) parent.getItemAtPosition(position) ;

                String title = item.getTitle() ;
                String description = item.getDescription() ;
                Drawable icon = item.getIcon() ;
                Toast.makeText(MainActivity.this, title + " ::: "+description, Toast.LENGTH_SHORT).show();

            }
        }) ;

        Button btnAdd = (Button) findViewById( R.id.btnAdd ) ;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCount++;
                if( AddCount==1 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.browse_24dp),
                            "DATA", "browse_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.camera_24dp),
                            "DATA", "camera_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.contrast_square_24dp),
                            "DATA", "contrast_square_24dp") ;
                }else if( AddCount==2 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.deblur_24dp),
                            "ICON", "deblur_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.exposure_24dp),
                            "ICON", "exposure_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.face_retouching_off_24dp),
                            "ICON", "face_retouching_off_24dp") ;
                }else if( AddCount==3 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.feature_search_24dp),
                            "ICON", "feature_search_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.filter_24dp),
                            "ICON", "filter_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grid_on_24dp),
                            "ICON", "grid_on_24dp") ;
                }else if( AddCount==4 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.landscape_24dp),
                            "ICON", "landscape_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.landscape_2_24dp),
                            "ICON", "landscape_2_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.linked_camera_24dp),
                            "ICON", "linked_camera_24dp") ;
                }else if( AddCount==5 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lists_24dp),
                            "ICON", "lists_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.macro_auto_24dp),
                            "ICON", "macro_auto_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.masked_transitions_add_24dp),
                            "ICON", "masked_transitions_add_24dp") ;
                }else if( AddCount==6 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.monochrome_photos_24dp),
                            "ICON", "monochrome_photos_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.offline_pin_24dp),
                            "ICON", "offline_pin_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.problem_24dp),
                            "ICON", "problem_24dp") ;
                }else if( AddCount==7 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.reminder_24dp),
                            "ICON", "reminder_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sdk_24dp),
                            "ICON", "sdk_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.settings_photo_camera_24dp),
                            "ICON", "settings_photo_camera_24dp") ;
                }else if( AddCount==8 ){
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unknown_2_24dp),
                            "ICON", "unknown_2_24dp") ;
                    adapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wb_sunny_24dp),
                            "ICON", "wb_sunny_24dp") ;
                }
                //adapter.notifyDataSetChanged();
            }
        });

    }
}