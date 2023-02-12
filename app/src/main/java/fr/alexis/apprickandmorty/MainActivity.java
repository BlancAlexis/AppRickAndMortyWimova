package fr.alexis.apprickandmorty;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

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
instance=this;


        TabPerso listPerso=TabPerso.getInstance();

        dataAdapterPerso = new DataAdapterPerso(getApplicationContext(), listPerso);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapterPerso);



        retrofit2.Retrofit retrofit= new retrofit2.Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
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
        Snackbar.make(recyclerView.getRootView(),"Merci d'attendre la fin du chargement avant de tenter toutes modifications", Snackbar.LENGTH_LONG).show();
        for (int i=0; i<825;i++) {

            service.getAllCharacter(i).enqueue(new Callback<Characters>() {
                @Override
                public void onResponse(Call<Characters> call, Response<Characters> response) {
                    if (response.isSuccessful()) {
                        listPerso.addPerso(response.body());
                        dataAdapterPerso.notifyDataSetChanged();
                       /* System.out.println(chara.getName());
                        System.out.println(listPerso.getCounts());
                        listPerso.affichage();*/
                    }


                }

                @Override
                public void onFailure(Call<Characters> call, Throwable t) {
                    System.out.println("jsuis pas co");
                }
            });
        }

        service.getEpisodeDetail(1).enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {

            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {

            }
        });


        System.out.println("fini");
       /* @Override
        public Call<Character> getAllCharacter() {
            return null;
        }

        @Override
        public Call<Location> getAllLocalisation() {
            return null;
        }

        @Override
        public Call<Episode> getAllEpisode() {
            return null;
        }
    } */

    }
    public static MainActivity getInstance(){
        return instance;
    }
    public DataAdapterPerso getAdapter(){
        return dataAdapterPerso;
    }
    public Activity getActivity(){
        return this;
    }
}