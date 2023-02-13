package fr.alexis.apprickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.alexis.apprickandmorty.recyclerEpisode.DataAdapterEpi;
import fr.alexis.apprickandmorty.recyclerPerso.DataAdapterPerso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewEpi extends AppCompatActivity {
    List<String> listEpisode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_epi);

        TabEpi tabEpisode=TabEpi.getInstance();


        Intent intent = getIntent();
        listEpisode=TabPerso.getInstance().getListPerso().get(Integer.parseInt(intent.getExtras().get("position").toString())).getListpisode();

        ArrayList<Episode> afficher=new ArrayList<>();
        DataAdapterEpi dataAdapterEpi = new DataAdapterEpi(getApplicationContext(), afficher);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEpi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapterEpi);


        for(int i=0;i<listEpisode.size();i++){
            afficher.add(tabEpisode.getListEpi().get(Integer.parseInt(listEpisode.get(i).substring(listEpisode.get(i).length()-2).replace("/",""))-1));
            dataAdapterEpi.notifyDataSetChanged();
        }

    }
}
