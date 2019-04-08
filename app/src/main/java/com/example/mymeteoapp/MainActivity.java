package com.example.mymeteoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    DrawerLayout m_drawerlayout;
    NavigationView m_navigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Active le menu burger
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);

        //Retrouve la référence du DrawerLayout
        m_drawerlayout = (DrawerLayout) findViewById(R.id.homepage_drawer_layout);

        //Retrouve le référence de la NavigationView et la configure
        m_navigationview = (NavigationView) findViewById(R.id.homepage_nav_view);

        //Manage les clics de l'utilisateur dans le menu latéral
        m_navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return manageNavigationViewItemClick(menuItem);
            }
        });

    }

    private boolean manageNavigationViewItemClick(MenuItem item) {
        item.setChecked(true);
        m_drawerlayout.closeDrawers();

        /*if (item.getItemId() == R.id.menu_forecast) {
            startActivity(new Intent(this, MeteoActivity.class));
        } else*/ if (item.getItemId() == R.id.menu_list_forecast) {
            startActivity(new Intent(this, ListViewActivity.class));
        }

        return true;
    }


    //Cette fonction est appelée lorsque l'utilisateur clique sur un bouton de la Toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Si l'utilisateur a cliqué notre menu burger, on affiche le menu latéral
        if (item.getItemId() == android.R.id.home)
            m_drawerlayout.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

    public void login (View v) {

        Intent meteo = new Intent(this, ListViewActivity.class);
        TextView email = findViewById(R.id.editText2);
        meteo.putExtra("email", email.getText().toString());
        startActivity(meteo);

    }

    public void callWebService (View v) {
        String sURL = "https://www.prevision-meteo.ch/services/json/grenoble";

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        final TextView text = (TextView)findViewById(R.id.textView);

        StringRequest request = new StringRequest(Request.Method.GET, sURL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        text.setText(response);
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
