package com.example.manoel.maratoneia1.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.maratoneia1.R;

public class MovieHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle;
    private ImageView movieBackdrop;


    public MovieHolder(View itemView) {
        super(itemView);
        movieTitle = itemView.findViewById(R.id.movieBackdropFrag);
        movieBackdrop = itemView.findViewById(R.id.movieTitleFrag);
    }






}
