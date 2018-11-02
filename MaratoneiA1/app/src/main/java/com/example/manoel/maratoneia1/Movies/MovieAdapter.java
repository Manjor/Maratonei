package com.example.manoel.maratoneia1.Movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.movie.movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private List<Movie> movieList = null;
    private List<movie> movies = null;


    public MovieAdapter(List<movie> movies){
        this.movies = movies;
    }


    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);

        return new MovieHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolder holder, int position) {
        movie movieObject = movies.get(position);
        //holder.getMovieTitleCategory().setText(movie.getMovieName());

        final int id = movieObject.getId();
        try{
            Picasso.get().load(Configuracao.urlImageApi + movieObject.getBackdropPath()).into(holder.getMovieBackdrop());

        }catch (Exception e){

        }
        holder.getMovieBackdrop().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailsMovie.class);
                Bundle bundle = new Bundle();

                intent.putExtra("id",id);

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }
}
