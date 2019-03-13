package com.example.mymeteoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.maximeesprit.myapplication.DonneesMeteo;

public class MeteoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meteo);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        TextView bienvenue = findViewById(R.id.text_bienvenue);
        bienvenue.append(email+" !");

        //TODO Pour afficher la météo d'une ville
        //String city = intent.getStringExtra("city");

    }

    public void callWebService (View v) {
        String sURL = "https://www.prevision-meteo.ch/services/json/grenoble";

        RequestQueue queue = Volley.newRequestQueue(MeteoActivity.this);
        final TextView text = (TextView)findViewById(R.id.textView);
        text.setText("Loading...");

        StringRequest request = new StringRequest(Request.Method.GET, sURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        DonneesMeteo dm = new DonneesMeteo(response);
                        text.setText(dm.getCurrentCondition().toString());
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        text.setText(error.getMessage());
                    }
                });

        queue.add(request);

    }

/*
    public class DownloadFilesTask extends AsyncTask<String, Boolean, Boolean> {

        protected void onPreExecute(){}

        protected Boolean doInBackground(String... urls) {

            //Can take several seconds here : UI won't be blocked
            refreshFromInternet();

            return true;
        }

        protected void onPostExecute(Boolean result) {}

        private void refreshFromInternet() {

            //Simule un appel au web service
            //bloque le thread pendant 5 secondes
            try {
                Thread.sleep(5000);
                final TextView text = (TextView)findViewById(R.id.textView);
                text.setText("5 sec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    */
}
