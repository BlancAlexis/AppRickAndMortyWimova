package fr.alexis.apprickandmorty;

import android.location.Location;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestAPI {
    @GET("character/{id}")
    Call<Characters> getAllCharacter(@Path("id") int itérateur);
    @GET("character/info/count")
    Call<Integer> getCountCharacter();
    @GET("episode/{num]")
    Call<Episode> getEpisodeDetail();
/*    @GET("episodes")
    Call<Episode> getAllEpisode();*/

}

