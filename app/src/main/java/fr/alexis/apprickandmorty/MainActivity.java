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
import java.util.List;

import fr.alexis.apprickandmorty.recyclerPerso.DataAdapterPerso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static volatile MainActivity instance;
    DataAdapterPerso dataAdapterPerso;

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

        //Call<Integer> countCharacter = service.getCountCharacter();
        //int count=
        // System.out.println(parseInt(countCharacter.toString()));
      /*  Call<Integer> call=service.getCountCharacter();
        try {
            Response<Integer> response = call.execute();
            if (response.isSuccessful()) {
                int count = response.body();
                System.out.println(count);
                // int numberOfCharacters = result.getInfo().getCount();
            } else {
                Log.e("Erreur request count","Request failed with error code: " + response.code());
            }
        } catch (IOException e) {
            Toast.makeText(this, "Erreur request API", Toast.LENGTH_SHORT).show();
            Log.e("Erreur request count","Request failed with exception: " + e.getMessage());
        }

       */

      /*  service.getEpisodeDetail().enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                System.out.println("RAFGAZHSDEJFRKEGFXBKVS<J?NHFD");
                Log.e("J'ai QUELQUECHOSE","YO BEBOU");
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {

            }
        });*/
        Snackbar snackWait = Snackbar.make(recyclerView, "Merci de patienter pendant le chargement", 200000);
        snackWait.setBackgroundTint(Color.GRAY).show();

        for (int i = 0; i < 825; i++) {

            service.getAllCharacter(i).enqueue(new Callback<Characters>() {
                @Override
                public void onResponse(Call<Characters> call, Response<Characters> response) {
                    if (response.isSuccessful()) {
                        listPerso.addPerso(response.body());
                        dataAdapterPerso.notifyDataSetChanged();
                        System.out.println(listPerso.getCounts());
                        if (listPerso.getListPerso().size()==824) {
                            snackWait.dismiss();
                            Toast.makeText(getApplicationContext(), "C'est partie", Toast.LENGTH_SHORT).show();


                        }}else{
                            Log.e("Erreur onResponse Character", "Données null");

                    }
                }

                @Override
                public void onFailure(Call<Characters> call, Throwable t) {
                    Log.e("Erreur onFailure Character", "onFailure : " + t.toString());

                }
            });
        }

        TabEpi tabEpi = TabEpi.getInstance();
        for (int i = 1; i < 52; i++) {
            service.getEpisodeDetail(i).enqueue(new Callback<Episode>() {
                @Override
                public void onResponse(Call<Episode> call, Response<Episode> response) {
                    if (response.isSuccessful()) {
                        tabEpi.getListEpi().add(response.body());
                        if(tabEpi.getListEpi().size()==51) {
                            Collections.sort(tabEpi.getListEpi(), (e1, e2) -> Integer.valueOf(e1.getId()).compareTo(Integer.valueOf(e2.getId())));
                        }

                    }else{
                        Log.e("Erreur on Response Episode", "Données null");
                    }
                }


                @Override
                public void onFailure(Call<Episode> call, Throwable t) {
                    Log.e("Erreur onFailure Episode", "onFailure : " + t.toString());
                }
            });
        }
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