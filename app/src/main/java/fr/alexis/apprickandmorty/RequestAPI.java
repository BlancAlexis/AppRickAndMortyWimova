package fr.alexis.apprickandmorty;

import android.location.Location;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestAPI {
    @GET("character/{id}")
    Call<Characters> getAllCharacter(@Path("id") int itérateur);
    @GET("locations")
    Call<Location> getAllLocalisation();
/*    @GET("episodes")
    Call<Episode> getAllEpisode();*/

}

