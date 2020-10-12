package com.uc.moviedb_0706011910022.ui.movie;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uc.moviedb_0706011910022.R;
import com.uc.moviedb_0706011910022.model.Movie;
import com.uc.moviedb_0706011910022.ui.splash.SplashFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieFragment extends Fragment {

    @BindView(R.id.btn_movie)
    Button button;


    public MovieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Movie movie = new Movie();

        button.setOnClickListener(v -> {
            NavDirections action = MovieFragmentDirections.actionMovieDetail(movie);
            Navigation.findNavController(v).navigate(action);
        });
}
}