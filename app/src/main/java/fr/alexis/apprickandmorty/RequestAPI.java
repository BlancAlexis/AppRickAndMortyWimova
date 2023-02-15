package fr.alexis.apprickandmorty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestAPI {
    @GET("character")
    Call<APIResponseChara> getPageCharacters(@Query("page") int page);

    @GET("episode/{id}")
    Call<Episode> getEpisodeDetail(@Path("id") int a);
    @GET("episode")
    Call<APIResponseEpi> getPageEpisodes(@Query("page") int page);
}