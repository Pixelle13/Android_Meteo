package com.example.mymeteoapp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.maximeesprit.myapplication.DonneesMeteo;
import com.example.maximeesprit.myapplication.FcstDay;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    //Listview
    ListView m_listview;

    //Swipe refresher
    SwipeRefreshLayout m_refresher;

    //Liste des éléments à afficher
    List<FcstDay> m_lsDaysToShow = new ArrayList<FcstDay>();

    //Adapter
    ArrayAdapter<FcstDay> m_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //Retrieve views form XML
        //////m_listview = findViewById(R.id.listview);
        //////m_refresher = findViewById(R.id.swiperefreshlayout);

        //Instancie une variable de type ArrayAdapter
        m_adapter = new MeteoAdapter(this,0);

        //Indique à la ListView quel Adapter elle doit utiliser
        m_listview.setAdapter(m_adapter);


        //Lorsque l'utilisateur fait un SwipeToRefresh
        m_refresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Rafraîchit les données de la ListView
                callWebService();
            }
        });

        //Permet d'initialiser les données de la ListView à l'ouverture de la page
        m_refresher.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Rafraîchit les données de la ListView
                callWebService();
            }
        }, 0);


        //NE PAS FAIRE COMME CECI : Peuple la ListView
        //////////PopulateSimpleList();

    }

/*
    private void PopulateSimpleList() {

        //Indique à l'utilisateur qu'il y a un chargement en cours
        m_refresher.setRefreshing(true);

        //Vide la liste des items
        m_lsDaysToShow.clear();

        callWebService();

        //Informe l'adapter que les données ont changés,
        //il va falloir alors mettre à jour la ListView
        m_adapter.notifyDataSetChanged();

        //Cache le loader
        m_refresher.setRefreshing(false);

    }
    */
    private void callWebService() {
        String sURL = "https://www.prevision-meteo.ch/services/json/grenoble";

        RequestQueue queue = Volley.newRequestQueue(ListViewActivity.this);

        StringRequest request = new StringRequest(Request.Method.GET, sURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String json = response;
                        try {
                            //Récupère le JSON complet
                            DonneesMeteo donneesMeteo = new DonneesMeteo(json);

                            //Vide la liste
                            m_lsDaysToShow.clear();

                            //Ajoute les données récupérées à a liste des jours à afficher
                            m_lsDaysToShow.add(donneesMeteo.getFcstDay0());
                            m_lsDaysToShow.add(donneesMeteo.getFcstDay1());
                            m_lsDaysToShow.add(donneesMeteo.getFcstDay2());
                            m_lsDaysToShow.add(donneesMeteo.getFcstDay3());
                            m_lsDaysToShow.add(donneesMeteo.getFcstDay4());

                            //Informe l'adapter qu'il doit afficher notre nouvelle liste
                            //c'est l'adapteur qui va modifier la ListView
                            m_adapter.addAll(m_lsDaysToShow);

                        } catch (Exception e) {}
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(request);
    }

}