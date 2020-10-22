package com.uc.moviedb_0706011910022.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.moviedb_0706011910022.model.Cast;
import com.uc.moviedb_0706011910022.model.CastResponse;
import com.uc.moviedb_0706011910022.model.Genre;
import com.uc.moviedb_0706011910022.model.GenreResponse;
import com.uc.moviedb_0706011910022.model.TvShow;
import com.uc.moviedb_0706011910022.model.TvShowResponse;
import com.uc.moviedb_0706011910022.network.ApiEndpoints;
import com.uc.moviedb_0706011910022.network.RetrofitService;
import com.uc.moviedb_0706011910022.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowRepository {

    private static TvShowRepository tvShowRepository;
    private ApiEndpoints apiEndpoints;
    private RetrofitService service;
    private static final String TAG = "TvShowRepository";

//    public MovieRepository(ApiEndpoints apiEndpoints) {
//        this.apiEndpoints = apiEndpoints;
//    }

    private TvShowRepository() {
        service = RetrofitService.getInstance();
    }

//    public static MovieRepository getInstance() {
//        if (movieRepository == null) {
//            movieRepository = new MovieRepository(RetrofitService.createService(ApiEndpoints.class));
//        }
//        return movieRepository;
//    }


    public static TvShowRepository getInstance() {
        if (tvShowRepository == null) {
            tvShowRepository = new TvShowRepository();
        }
        return tvShowRepository;
    }


    public MutableLiveData<List<TvShow>> getTvShowCollection() {
        MutableLiveData<List<TvShow>> listTvShow = new MutableLiveData<>();

        service.getTvShow().enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        listTvShow.postValue(response.body().getResults());
                    }

                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listTvShow;
    }

    public MutableLiveData<List<Genre>> getGenres(int id) {
        MutableLiveData<List<Genre>> listGenres = new MutableLiveData<>();

        service.getGenre(Constants.Type.TV_SHOWS, id).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getGenres().size());
                        listGenres.postValue(response.body().getGenres());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listGenres;
    }

    public MutableLiveData<List<Cast>> getCasts(int id) {
        MutableLiveData<List<Cast>> listCasts = new MutableLiveData<>();

        service.getCast(Constants.Type.TV_SHOWS, id).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getCast().size());
                        listCasts.postValue(response.body().getCast());
                    }
                }
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listCasts;
    }
}
