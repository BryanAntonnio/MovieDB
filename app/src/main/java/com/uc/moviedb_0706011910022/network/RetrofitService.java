package com.uc.moviedb_0706011910022.network;

import com.uc.moviedb_0706011910022.model.CastResponse;
import com.uc.moviedb_0706011910022.model.GenreResponse;
import com.uc.moviedb_0706011910022.model.MovieResponse;
import com.uc.moviedb_0706011910022.model.TvShowResponse;
import com.uc.moviedb_0706011910022.util.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {


    private ApiEndpoints api;
    private static RetrofitService service;

    private RetrofitService() {
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiEndpoints.class);
    }

    public static RetrofitService getInstance() {
        if (service == null) {
            service = new RetrofitService();
        }
        return service;
    }

    public Call<MovieResponse> getMovies() {
        return api.getMovies(Constants.API_KEY);
    }

    public Call<TvShowResponse> getTvShow() {
        return api.getTvShow(Constants.API_KEY);
    }

    public Call<GenreResponse> getGenre(String type, int id) {
        return api.getGenres(type, id, Constants.API_KEY);
    }

    public Call<CastResponse> getCast(String type, int id) {
        return api.getCasts(type, id, Constants.API_KEY);
    }
}
