package com.example.manoel.maratoneia1.Movies;

public class Movie {


    private String movieName;
    private String movieImg;
    private int movieId;


    public Movie(){}

    public Movie(String movieName, String movieImg, int movieId) {
        this.movieName = movieName;
        this.movieImg = movieImg;
        this.movieId = movieId;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
