package com.example.manoel.prototipomaratonei.Class;

import java.util.List;

public class Movie {

    //Starter Atributes
    private int id;
    private String title;
    private String originalTitle;
    private String overview;
    private String urlPosterPath;
    private String releaseDate;

    //Details Atributes
    //
    //private List<String> genres;
    //private String urlHomePage;


    //Construct

    public Movie(int id, String title, String originalTitle, String overview, String urlPosterPath, String releaseDate) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.urlPosterPath = urlPosterPath;
        this.releaseDate = releaseDate;
    }

    public Movie(){

    }


    //Starter Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUrlPosterPath() {
        return urlPosterPath;
    }

    public void setUrlPosterPath(String urlPosterPath) {
        this.urlPosterPath = urlPosterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
