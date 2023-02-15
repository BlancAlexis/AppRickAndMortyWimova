package fr.alexis.apprickandmorty;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;

import fr.alexis.apprickandmorty.recyclerPerso.DataAdapterPerso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static volatile MainActivity instance;
    DataAdapterPerso dataAdapterPerso;
    Snackbar snackWait;
    int pageCountChara=1;
    int pageCountEpi=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;


        TabPerso listPerso = TabPerso.getInstance();

        dataAdapterPerso = new DataAdapterPerso(getApplicationContext(), listPerso);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapterPerso);


        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestAPI service = retrofit.create(RequestAPI.class);


        getPageChara(service);
        getPageEpisode(service);


        snackWait=Snackbar.make(recyclerView, "Merci de patienter pendant le chargement", 20000);
        snackWait.setBackgroundTint(Color.GRAY).show();

   }
    public void getPageChara(RequestAPI service){
        TabPerso listPerso=TabPerso.getInstance();
      service.getPageCharacters(pageCountChara).enqueue(new Callback<APIResponseChara>() {
                @Override
                public void onResponse(Call<APIResponseChara> call, Response<APIResponseChara> response) {
                    if(response.isSuccessful()) {
                        listPerso.addAll(response.body().getCharacters());
                        dataAdapterPerso.notifyDataSetChanged();
                        Info info = response.body().getInfo();
                        if (info.getNext() != null) {
                            pageCountChara++;
                            getPageChara(service);
                        } else {
                            System.out.println("Tous les personnages sont chargé!");
                            snackWait.dismiss();
                            Toast.makeText(getApplicationContext(), "Prêt", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Log.e("Erreur", "Erreur de requête charactère");
                        Toast.makeText(getApplicationContext(), "échec communication API",Toast.LENGTH_LONG).show();
                    }
                }

            @Override
            public void onFailure(Call<APIResponseChara> call, Throwable t) {
                Log.e("Erreur", "Erreur charactère : "+t);
                Toast.makeText(getApplicationContext(), "échec communication API",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void getPageEpisode(RequestAPI service){
        TabEpi listEpi=TabEpi.getInstance();
        service.getPageEpisodes(pageCountEpi).enqueue(new Callback<APIResponseEpi>() {
            @Override
            public void onResponse(Call<APIResponseEpi> call, Response<APIResponseEpi> response) {
                System.out.println(listEpi.getListEpi().size()+"jsuuis gros");
                if(response.isSuccessful()) {
                    listEpi.addAll(response.body().getEpisodes());
                    Info info = response.body().getInfo();
                    if (info.getNext() != null) {
                        pageCountEpi++;
                        getPageEpisode(service);
                    } else {
                        Collections.sort(listEpi.getListEpi(), (e1, e2) -> Integer.valueOf(e1.getId()).compareTo(Integer.valueOf(e2.getId())));

                    }
                }else{
                    Log.e("Erreur", "Erreur de requête épisode");
                    Toast.makeText(getApplicationContext(), "échec communication API",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<APIResponseEpi> call, Throwable t) {
                Log.e("Erreur ", "Erreur épisode : "+t);
                Toast.makeText(getApplicationContext(), "échec communication API",Toast.LENGTH_LONG).show();
            }
        });
    }


    public static MainActivity getInstance() {
        return instance;
    }

    public DataAdapterPerso getAdapter() {
        return dataAdapterPerso;
    }

    public Activity getActivity() {
        return this;
    }


}