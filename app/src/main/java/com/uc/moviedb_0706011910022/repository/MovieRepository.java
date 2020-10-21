package com.uc.moviedb_0706011910022.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.moviedb_0706011910022.model.Movie;
import com.uc.moviedb_0706011910022.model.MovieResponse;
import com.uc.moviedb_0706011910022.network.ApiEndpoints;
import com.uc.moviedb_0706011910022.network.RetrofitService;
import com.uc.moviedb_0706011910022.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository movieRepository;
    private RetrofitService service;
    private static final String TAG = "MovieRepository"; //ketik logt biar langsung muncul TAGnya

    private MovieRepository(){
        service = RetrofitService.getInstance();
    }

    public static MovieRepository getInstance(){
        if (movieRepository == null){
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Movie>> getMovieCollection() {
        MutableLiveData<List<Movie>> listMovie = new MutableLiveData<>();

        service.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                if (response.isSuccessful()){
                    if (response.body()!= null){
                        listMovie.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listMovie;
    }
}
