package com.example.manoel.maratoneia1.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;


public class MovieHolderCategory extends RecyclerView.ViewHolder {

    private TextView movieTitleCategory;
    private ImageView movieBackdrop;


    public MovieHolderCategory(View itemView) {
        super(itemView);
        this.movieTitleCategory = itemView.findViewById(R.id.txtNameMovieCategory);
        this.movieBackdrop = itemView.findViewById(R.id.serieBackdropFrag);
    }

    public TextView getMovieTitleCategory() {
        return movieTitleCategory;
    }

    public void setMovieTitleCategory(TextView movieTitleCategory) {
        this.movieTitleCategory = movieTitleCategory;
    }

    public ImageView getMovieBackdrop() {
        return movieBackdrop;
    }

    public void setMovieBackdrop(ImageView movieBackdrop) {
        this.movieBackdrop = movieBackdrop;
    }
}
