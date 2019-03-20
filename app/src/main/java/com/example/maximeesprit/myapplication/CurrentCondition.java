package com.example.maximeesprit.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrentCondition {

    private String date;
    private String hour;
    private int tmp;
    private int wnd_spd;
    private int wnd_gust;
    private String wnd_dir;
    private double pressure;
    private int humidity;
    private String condition;
    private String condition_key;
    private String icon;
    private String icon_big;

    public CurrentCondition(JSONObject object) throws JSONException {

        date = object.getString("date");
        hour = object.getString("hour");
        tmp = object.getInt("tmp");
        wnd_spd = object.getInt("wnd_spd");
        wnd_gust = object.getInt("wnd_gust");
        wnd_dir = object.getString("wnd_dir");
        pressure = object.getDouble("pressure");
        humidity = object.getInt("humidity");
        condition = object.getString("condition");
        condition_key = object.getString("condition_key");
        icon = object.getString("icon");
        icon_big = object.getString("icon_big");
    }


    public String toString() {
        return "Date : "+this.date+
                "\nHour : "+this.hour+
                "\nTmp : "+this.tmp+
                "\nWind speed : "+this.wnd_spd+
                "\nWind gust : "+this.wnd_gust+
                "\nWind direction : "+this.wnd_dir+
                "\nPressure : "+this.pressure+
                "\nHumidity : "+this.humidity+
                "\nCondition : "+this.condition+
                "\nCondition key : "+this.condition_key+
                "\nIcon : "+this.icon+
                "\nIcon big : "+this.icon_big;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public int getWnd_spd() {
        return wnd_spd;
    }

    public void setWnd_spd(int wnd_spd) {
        this.wnd_spd = wnd_spd;
    }

    public int getWnd_gust() {
        return wnd_gust;
    }

    public void setWnd_gust(int wnd_gust) {
        this.wnd_gust = wnd_gust;
    }

    public String getWnd_dir() {
        return wnd_dir;
    }

    public void setWnd_dir(String wnd_dir) {
        this.wnd_dir = wnd_dir;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
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
}
