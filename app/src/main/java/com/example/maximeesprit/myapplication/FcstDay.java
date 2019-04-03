package com.example.maximeesprit.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class FcstDay {


    private String date;
    private String day_short;
    private String day_long;
    private int tmin;
    private int tmax;
    private String condition;
    private String condition_key;
    private String icon;
    private String icon_big;
    private JSONObject hourly_data;

    private JSONObject object;

    public FcstDay(JSONObject object) throws JSONException {

        date = object.getString("date");
        day_short = object.getString("day_short");
        day_long = object.getString("day_long");
        tmin = object.getInt("tmin");
        tmax = object.getInt("tmax");
        condition = object.getString("condition");
        condition_key = object.getString("condition_key");
        icon = object.getString("icon");
        icon_big = object.getString("icon_big");
        hourly_data = object.getJSONObject("hourly_data");
        this.object = object;
    }


    public String toJsonString() {
        return object.toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay_short() {
        return day_short;
    }

    public void setDay_short(String day_short) {
        this.day_short = day_short;
    }

    public String getDay_long() {
        return day_long;
    }

    public void setDay_long(String day_long) {
        this.day_long = day_long;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition_key() {
        return condition_key;
    }

    public void setCondition_key(String condition_key) {
        this.condition_key = condition_key;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_big() {
        return icon_big;
    }

    public void setIcon_big(String icon_big) {
        this.icon_big = icon_big;
    }

    public JSONObject getHourly_data() {
        return hourly_data;
    }

    public void setHourly_data(JSONObject hourly_data) {
        this.hourly_data = hourly_data;
    }


}
