package com.uc.moviedb_0706011910022.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uc.moviedb_0706011910022.R;
import com.uc.moviedb_0706011910022.model.Movie;
import com.uc.moviedb_0706011910022.ui.movie.MovieFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewViewHolder> {

    private Context context;
    private List<Movie> listMovie;

    private List<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public MovieAdapter(Context context) {
        this.listMovie = new ArrayList<Movie>();
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new MovieAdapter.CardViewViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final CardViewViewHolder holder, int position) {
        Movie movie = getListMovie().get(position);
        Glide.with(context).load(movie.getCover()).centerCrop().into(holder.img);
        holder.lbl_title.setText(movie.getTitle());
        holder.lbl_vote.setText(movie.getVote_average());

        holder.itemView.setOnClickListener(v -> {
            NavDirections action = MovieFragmentDirections.actionMovieDetail(movie, null);
            Navigation.findNavController(v).navigate(action);
        });
//        Log.d("Movie",movie.getPoster());
    }

    @NonNull
    @Override
    public int getItemCount() {
        return getListMovie().size();
    }


    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView lbl_title;
        TextView lbl_vote;

        CardViewViewHolder(View itemView) {
            super(itemView);
            lbl_title = itemView.findViewById(R.id.lbl_title);
            lbl_vote = itemView.findViewById(R.id.lbl_vote);
            img = itemView.findViewById(R.id.imageViewAdapter);

        }
    }
}
