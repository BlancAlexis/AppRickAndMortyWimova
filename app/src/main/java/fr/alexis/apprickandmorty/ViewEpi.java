package fr.alexis.apprickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

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

        DataAdapterEpi dataAdapterEpi = new DataAdapterEpi(getApplicationContext(), tabEpisode);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEpi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapterEpi);


        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestAPI service = retrofit.create(RequestAPI.class);

        Intent intent = getIntent();
        listEpisode=TabPerso.getInstance().getListPerso().get(Integer.parseInt(intent.getExtras().get("position").toString())).getListpisode();

        for (int i = 0; i < listEpisode.size(); i++) {

            Snackbar.make(recyclerView.getRootView(), "Merci d'attendre la fin du chargement avant de tenter toutes modifications", Snackbar.LENGTH_LONG).show();


            service.getEpisodeDetail(i).enqueue(new Callback<Episode>() {
                @Override
                public void onResponse(Call<Episode> call, Response<Episode> response) {
                    tabEpisode.getListEpi().add(response.body());
                    dataAdapterEpi.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Episode> call, Throwable t) {

                }
            });
        }
    }
}
