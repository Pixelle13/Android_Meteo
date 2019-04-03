package com.example.mymeteoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maximeesprit.myapplication.HourlyData;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public class DetailAdapter extends ArrayAdapter<HourlyData> {

    private final Context m_context;
    private final ArrayList<HourlyData> m_lsItems;

    public DetailAdapter(Context context, int resource) {
        super(context, resource);
        this.m_context = context;
        this.m_lsItems = new ArrayList<HourlyData>();
    }

    @Override
    public int getPosition(HourlyData item) {
        return m_lsItems.indexOf(item);
    }

    @Override
    public int getCount() {
        return m_lsItems.size();
    }

    @Override
    public HourlyData getItem(int position) {
        return m_lsItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Obtient un objet Inflater
        LayoutInflater inflater = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflate le layout XML listview_item
        View rowView = inflater.inflate(R.layout.activity_detail_item, parent, false);

        //Référence les vues
        TextView textViewHour = (TextView) rowView.findViewById(R.id.hourDetail);
        TextView textViewCondition = (TextView) rowView.findViewById(R.id.hourConditionDetail);
        TextView textViewTemp = (TextView) rowView.findViewById(R.id.hourTempDetail);
        TextView textViewWindSpd = (TextView) rowView.findViewById(R.id.hourWindSpdDetail);
        TextView textViewWindDir = (TextView) rowView.findViewById(R.id.hourWindDirDetail);
        TextView textViewHumidity = (TextView) rowView.findViewById(R.id.hourHumidityDetail);
        ImageView hourImageView = (ImageView) rowView.findViewById(R.id.hourIconDetail);

        //Le FcstDay à afficher sur cet item de la liste
        HourlyData hourToShow = getItem(position);

        ///////hourToShow = dayToShow.getHourly_data().getJSONObject(position+"H00");

        //Valorise les vues avec le FcstDay correspondant
        textViewHour.setText(hourToShow.getId_hour()+"H");
        textViewCondition.setText(hourToShow.getCondition());
        textViewTemp.setText("Température : "+hourToShow.getTemperature()+"°C");
        textViewWindSpd.setText("Vent : "+hourToShow.getWind_spd()+"km/h");
        textViewWindDir.setText("Direction du vent : "+hourToShow.getWind_dir());
        textViewHumidity.setText("Humidité : "+hourToShow.getHumidity()+"%");
        Picasso.get().load(hourToShow.getIcon()).into(hourImageView);

        return rowView;

    }

    @Override
    public void addAll(Collection<? extends HourlyData> collection) {
        //Vide la liste actuelle
        m_lsItems.clear();

        //Ajoute les nouveaux éléments à la liste
        m_lsItems.addAll(collection);

        //Met à jour la ListView
        notifyDataSetChanged();
    }
}