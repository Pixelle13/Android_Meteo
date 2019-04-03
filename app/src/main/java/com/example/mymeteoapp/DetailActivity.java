package com.example.mymeteoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.maximeesprit.myapplication.FcstDay;
import com.example.maximeesprit.myapplication.HourlyData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private FcstDay m_dayToShow;

    ListView m_listview;
    ArrayAdapter<HourlyData> m_adapter;

    //Liste des éléments à afficher
    List<HourlyData> m_lsHoursToShow = new ArrayList<HourlyData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String sJsonExtra = this.getIntent().getStringExtra("dayToShow");

        //Desserialise le JSON
        try {
            m_dayToShow = new FcstDay(new JSONObject(sJsonExtra));
        } catch (JSONException jsone) {}

        //Instancie une variable de type ArrayAdapter

        m_listview = findViewById(R.id.detail);
        m_adapter = new DetailAdapter(this,0);

        for (int i=0 ; i<24 ; i++) {
            try {
                JSONObject item = m_dayToShow.getHourly_data().getJSONObject(i+"H00");
                m_lsHoursToShow.add(new HourlyData(i, item));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        m_adapter.addAll(m_lsHoursToShow);

        //Indique à la ListView quel Adapter elle doit utiliser
        m_listview.setAdapter(m_adapter);
    }
}
