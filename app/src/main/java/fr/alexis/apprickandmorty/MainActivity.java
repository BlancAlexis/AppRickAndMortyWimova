package fr.alexis.apprickandmorty;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabPerso listPerso=TabPerso.getInstance();

        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), listPerso);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapter);



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
        for (int i=0; i<825;i++) {

            service.getAllCharacter(i).enqueue(new Callback<Characters>() {
                @Override
                public void onResponse(Call<Characters> call, Response<Characters> response) {
                    if (response.isSuccessful()) {
                        listPerso.addPerso(response.body());
                        dataAdapter.notifyDataSetChanged();
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
   /* public static MainActivity getInstance(){
        return this;
    }*/
}