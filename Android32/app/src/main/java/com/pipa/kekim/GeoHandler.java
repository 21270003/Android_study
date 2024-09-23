package com.pipa.kekim;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoHandler {

    public Location getLocationFromAddress(Context context, String strAddress ) throws IOException {
        Location location = new Location( strAddress);

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> list = geocoder.getFromLocationName(strAddress, 2);
        if (list != null) {
            String city = "";
            String country = "";
            if (list.isEmpty()) {
                //address_result.setText("올바른 주소를 입력해주세요. ");
                location.setLatitude( (double)0.0 );
                location.setLongitude( (double)0.0 );
            }
            else {
                Address address = list.get(0);
                double lat = address.getLatitude();
                double lon = address.getLongitude();
                location.setLatitude(lat);
                location.setLongitude(lon);
            }
        }
        return location;
    }

}
