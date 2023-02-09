package fr.alexis.apprickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAdapter dataAdapter = new DataAdapter(getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dataAdapter);


        TabPerso listPerso=new TabPerso();
        retrofit2.Retrofit retrofit= new retrofit2.Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestAPI service = retrofit.create(RequestAPI.class);

        for (int i=0; i<825;i++) {
            service.getAllCharacter(i).enqueue(new Callback<Characters>() {
                @Override
                public void onResponse(Call<Characters> call, Response<Characters> response) {
                    if (response.isSuccessful()) {
                        Characters chara = response.body();
                        listPerso.addPerso(chara);
                        System.out.println(chara.getGender());
                        System.out.println("jsuis co");
                        System.out.println(listPerso.getCounts());
                        dataAdapter.notifyDataSetChanged();
                        recyclerView.postInvalidate();
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
    }
    */}
}