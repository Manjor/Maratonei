package com.example.manoel.maratoneia1.Movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.ResultMovie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapterCategory extends RecyclerView.Adapter<MovieHolderCategory> {

    private List<ResultMovie> movieList = null;
    public MovieAdapterCategory(List<ResultMovie> movieList){
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
        final ResultMovie movieObject = movieList.get(position);
        holder.getMovieTitleCategory().setText(movieObject.getTitle());
        final int id = movieObject.getId();
        try{
            Picasso.get().load(Configuracao.urlImageApi500 + movieObject.getBackdropPath()).into(holder.getMovieBackdrop());
            holder.getMovieBackdrop().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailsMovieActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtra("id",id);
                    v.getContext().startActivity(intent);
//                BottomSheetDetails bottom = new BottomSheetDetails(v.getContext());
//                bottom.setTitle("Resumo");
//                bottom.show();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
            Log.d("DEBUGADO", "erro:" + e.getMessage() + e.getCause());
        }



    }
    @Override
    public int getItemCount() {
        return this.movieList.size();
    }
}
