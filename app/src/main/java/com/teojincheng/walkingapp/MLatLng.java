package com.teojincheng.walkingapp;

/**
 * Created by Jin Cheng
 *
 * This class is constructed to retrieve the latlng stored in the firebase database.
 */

public class MLatLng {
    private Double latitude;
    private Double longitude;

    public MLatLng(){

    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
