package com.example.mymeteoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maximeesprit.myapplication.FcstDay;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;

public class MeteoAdapter extends ArrayAdapter<FcstDay> {

    private final Context m_context;
    private final ArrayList<FcstDay> m_lsItems;

    public MeteoAdapter(Context context, int resource) {
        super(context, resource);
        this.m_context = context;
        this.m_lsItems = new ArrayList<FcstDay>();
    }

    @Override
    public int getPosition(FcstDay item) {
        return m_lsItems.indexOf(item);
    }

    @Override
    public int getCount() {
        return m_lsItems.size();
    }

    @Override
    public FcstDay getItem(int position) {
        return m_lsItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Obtient un objet Inflater
        LayoutInflater inflater = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflate le layout XML listview_item
        View rowView = inflater.inflate(R.layout.activity_listview, parent, false);

        //Référence les vues
        TextView textViewDay = (TextView) rowView.findViewById(R.id.textviewDay);
        TextView textViewDesc = (TextView) rowView.findViewById(R.id.textviewDesc);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgviewMeteo);

        //Le FcstDay à afficher sur cet item de la liste
        FcstDay dayToShow = getItem(position);

        //Valorise les vues avec le FcstDay correspondant
        textViewDay.setText(dayToShow.getDay_long());
        textViewDesc.setText(dayToShow.getDate());
        Picasso.get().load(dayToShow.getIcon()).into(imageView);

        return rowView;
    }

    @Override
    public void addAll(Collection<? extends FcstDay> collection) {
        //Vide la liste actuelle
        m_lsItems.clear();

        //Ajoute les nouveaux éléments à la liste
        m_lsItems.addAll(collection);

        //Met à jour la ListView
        notifyDataSetChanged();
    }
}

