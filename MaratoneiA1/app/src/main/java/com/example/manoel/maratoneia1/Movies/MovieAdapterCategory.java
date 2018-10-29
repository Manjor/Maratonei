package com.example.manoel.maratoneia1.Movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.maratoneia1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapterCategory extends RecyclerView.Adapter<MovieHolderCategory> {

    private List<Movie> movieList = null;


    public MovieAdapterCategory(List<Movie> movieList){
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public MovieHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);

        return new MovieHolderCategory(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolderCategory holder, int position) {
        Movie movie = movieList.get(position);
        holder.getMovieTitle().setText(movie.getMovieName());

        final int id = movie.getMovieId();

        try{
            Picasso.get().load(movie.getMovieImg()).into(holder.getMovieBackdrop());

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
