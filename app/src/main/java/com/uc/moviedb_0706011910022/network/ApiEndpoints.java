package com.uc.moviedb_0706011910022.network;

import com.uc.moviedb_0706011910022.model.CastResponse;
import com.uc.moviedb_0706011910022.model.GenreResponse;
import com.uc.moviedb_0706011910022.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @GET("discover/movie") // buat movie
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}") //buat genre
    Call<GenreResponse> getMovieGenre(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits") //buat cast
    Call<CastResponse> getCastMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
