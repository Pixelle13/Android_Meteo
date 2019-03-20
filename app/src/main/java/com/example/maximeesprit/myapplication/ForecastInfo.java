package com.example.maximeesprit.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class ForecastInfo {


    private String latitude;
    private String longitude;
    private String elevation;

    public ForecastInfo(JSONObject object) throws JSONException {

        latitude = object.getString("latitude");
        longitude = object.getString("longitude");
        elevation = object.getString("elevation");
    }

    public String getLatitude() { return this.latitude; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }
}
