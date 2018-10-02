package com.example.manoel.maratoneia1.Movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.manoel.maratoneia1.R;

public class DetailsMovie  extends AppCompatActivity{


    //Atributes
    private ImageView movieBackdrop;
    private ImageView moviePoster;
    private VideoView movieVideo;
    private TextView movieTitle;
    private TextView movieOverview;
    private TextView movieDate;
    private TextView movieHomePage;

    private String urlPoster = null;
    private String urlBackdrop = null;
    private String overview = null;
    private String title = null;
    private String date = null;
    private String homepage = null;
    private String video = null;

    private String urlDetailsMovie = "";
    private String urlVideoMovie = "";

    private String response = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        movieBackdrop = findViewById(R.id.movieBackdrop);
        moviePoster = findViewById(R.id.moviePoster);
        movieVideo = findViewById(R.id.movieVideo);
        movieTitle = findViewById(R.id.movieTitle);
        movieOverview = findViewById(R.id.movieOverview);
        movieDate = findViewById(R.id.movieDate);
        movieHomePage = findViewById(R.id.movieHomePage);

        int movieId = this.getIntent().getIntExtra("id",0);

    }
}
