package com.example.manoel.maratoneia1.Movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manoel.maratoneia1.R;

public class MovieHolder extends RecyclerView.ViewHolder {

    private TextView movieTitle;
    private ImageView movieBackdrop;
    private ImageButton movieLike;
    private ImageButton movieShare;


    public MovieHolder(View itemView) {
        super(itemView);
        this.movieTitle = itemView.findViewById(R.id.movieTitleFrag);
        this.movieBackdrop = itemView.findViewById(R.id.movieBackdropFrag);
        this.movieLike = itemView.findViewById(R.id.movieLike);
        this.movieShare = itemView.findViewById(R.id.movieShare);
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

    public ImageButton getMovieLike() {
        return movieLike;
    }

    public void setMovieLike(ImageButton movieLike) {
        this.movieLike = movieLike;
    }

    public ImageButton getMovieShare() {
        return movieShare;
    }

    public void setMovieShare(ImageButton movieShare) {
        this.movieShare = movieShare;
    }
}
