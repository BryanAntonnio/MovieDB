package com.uc.moviedb_0706011910022.network;

import com.uc.moviedb_0706011910022.model.CastResponse;
import com.uc.moviedb_0706011910022.model.GenreResponse;
import com.uc.moviedb_0706011910022.model.MovieResponse;
import com.uc.moviedb_0706011910022.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);

    @GET("discover/tv")
    Call<TvShowResponse> getTvShow(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}")
    Call<GenreResponse> getGenres(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("{type}/{id}")
    Call<GenreResponse> getGenres(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

    @GET("{type}/{id}/credits")
    Call<CastResponse> getCasts(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);
}
