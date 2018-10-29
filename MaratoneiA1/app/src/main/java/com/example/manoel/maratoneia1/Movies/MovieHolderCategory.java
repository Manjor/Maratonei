package com.example.manoel.maratoneia1.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.maratoneia1.R;

public class MovieHolderCategory extends RecyclerView.ViewHolder {

    private TextView movieTitle;
    private ImageView movieBackdrop;


    public MovieHolderCategory(View itemView) {
        super(itemView);
        this.movieTitle = itemView.findViewById(R.id.txtNameMovieCategory);
        this.movieBackdrop = itemView.findViewById(R.id.txtImageMovieCategory);
    }

    public TextView getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(TextView movieTitle) {
        this.movieTitle = movieTitle;
    }

    public ImageView getMovieBackdrop() {
        return movieBackdrop;
    }

    public void setMovieBackdrop(ImageView movieBackdrop) {
        this.movieBackdrop = movieBackdrop;
    }

}
