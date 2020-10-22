package com.uc.moviedb_0706011910022.ui.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.moviedb_0706011910022.model.TvShow;
import com.uc.moviedb_0706011910022.repository.TvShowRepository;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private TvShowRepository repository;

    public TvShowViewModel() {
        repository = TvShowRepository.getInstance();
    }

    public LiveData<List<TvShow>> getTvShowCollection() {
        return repository.getTvShowCollection();
    }
}

