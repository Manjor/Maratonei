package com.example.manoel.maratoneia1.Movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.DataBase.MovieIntro;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapterCategory extends RecyclerView.Adapter<MovieHolderCategory> {

    //    private List<ResultMovie> movieList = null;
//    public MovieAdapterCategory(List<ResultMovie> movieList){
//        this.movieList = movieList;
//    }
    private List<MovieIntro> movieList = null;

    public MovieAdapterCategory(List<MovieIntro> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);

        return new MovieHolderCategory(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolderCategory holder, int position) {
        final MovieIntro movieObject = movieList.get(position);
        holder.getMovieTitleCategory().setText(movieObject.getTitle());
        final int id = movieObject.getId();
        try {
            try{
                Picasso.get().load(Config.URL_IMAGE_500 + movieObject.getBackdrop()).into(holder.getMovieBackdrop());
            }catch (Exception e){
                System.out.println("Não foi possível obter a imagem");
            }
            holder.getMovieBackdrop().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(MainActivity.CONNECTION == false){
                        Snackbar.make(v,v.getResources().getString(R.string.messageerrorconnection),Snackbar.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(v.getContext(), DetailsMovieActivity.class);
                        Bundle bundle = new Bundle();
                        intent.putExtra("id", id);
                        v.getContext().startActivity(intent);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro:" + e.getMessage() + e.getCause());

        }
    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }
}
