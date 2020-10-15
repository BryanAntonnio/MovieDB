package com.uc.moviedb_0706011910022.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.moviedb_0706011910022.model.Movie;
import com.uc.moviedb_0706011910022.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieRepository repository;

    public MovieViewModel() {
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<Movie>> getMovieCollection() {
        return repository.getMovieCollection();
    }
}
