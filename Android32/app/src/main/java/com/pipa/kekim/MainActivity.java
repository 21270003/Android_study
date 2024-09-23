package com.pipa.kekim;

import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapFragment mapFrag;
    GroundOverlayOptions locationMark;
    GoogleMap gMap;

    EditText editAddress;
    Button btnEntAddress;

    GeoHandler geoHandler = new GeoHandler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setTitle("Google 지도 활용");

        mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);

        editAddress = (EditText) findViewById(R.id.editAddress);
        btnEntAddress = (Button) findViewById(R.id.btnEntAddress);


        btnEntAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeoHandler geoHandler = new GeoHandler();
                try {
                    String targetAddress = editAddress.getText().toString();
                    Location location = geoHandler.getLocationFromAddress(getApplicationContext(), targetAddress);
                    //Toast.makeText(MainActivity.this,location.getLatitude() +":::" + location.getLongitude(), Toast.LENGTH_SHORT).show();
                    gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.568256, 126.897240), 20));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                locationMark = new GroundOverlayOptions().image(
                        BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(latLng, 400f, 400f);
                googleMap.addGroundOverlay(locationMark);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "위성 지도");
        menu.add(0, 2, 0, "일반 지도");
        menu.add(0, 3, 0, "월드컵경기장 바로가기");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                gMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        37.568256, 126.897240), 13));
                return true;
        }
        return false;
    }
}

