package com.uc.moviedb_0706011910022.ui.detail;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.moviedb_0706011910022.model.Cast;
import com.uc.moviedb_0706011910022.model.Genre;
import com.uc.moviedb_0706011910022.repository.MovieRepository;
import com.uc.moviedb_0706011910022.repository.TvShowRepository;

import java.util.List;

public class DetailViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private TvShowRepository tvShowRepository;

    public DetailViewModel() {
        movieRepository = MovieRepository.getInstance();
        tvShowRepository = TvShowRepository.getInstance();
    }

    public LiveData<List<Genre>> getMovieGenre(int id) {
        return movieRepository.getGenres(id);
    }

    public LiveData<List<Genre>> getTvShowGenre(int id) {
        return tvShowRepository.getGenres(id);
    }

    public LiveData<List<Cast>> getShowCast(int id) {
        return tvShowRepository.getCasts(id);
    }

    public LiveData<List<Cast>> getMovieCast(int id) {
        return movieRepository.getCasts(id);
    }
}
