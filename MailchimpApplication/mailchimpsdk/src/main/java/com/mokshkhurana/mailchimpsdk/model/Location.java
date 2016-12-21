package com.mokshkhurana.mailchimpsdk.model;


import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("latitude")
    private Number latitude;

    @SerializedName("longitude")
    private Number longitude;

    public Number getLatitude() {
        return latitude;
    }

    public Number getLongitude() {
        return longitude;
    }

    public void setLatitude(Number latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Number longitude) {
        this.longitude = longitude;
    }
}
