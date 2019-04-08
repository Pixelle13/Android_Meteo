package com.example.maximeesprit.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class HourlyData {


    private int id_hour;
    private String icon;
    private String condition;
    private String temperature;
    private String wind_spd;
    private String wind_dir;
    private String humidity;

    public HourlyData(int id, JSONObject jsonobject) throws JSONException {
        this.id_hour = id;
        this.icon = jsonobject.getString("ICON");
        this.condition = jsonobject.getString("CONDITION");
        this.temperature = jsonobject.getString("TMP2m");
        this.wind_spd = jsonobject.getString("WNDSPD10m");
        this.wind_dir = jsonobject.getString("WNDDIRCARD10");
        this.humidity = jsonobject.getString("RH2m");
    }

    public int getId_hour() {
        return id_hour;
    }

    public void setId_hour(int id_hour) {
        this.id_hour = id_hour;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind_spd() {
        return wind_spd;
    }

    public void setWind_spd(String wind_spd) {
        this.wind_spd = wind_spd;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
