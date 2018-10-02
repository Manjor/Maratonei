package com.example.manoel.prototipomaratonei.Class;

import java.util.List;

public class Serie {

    //Starter Atributes
    private int id;
    private String name;
    private String originalName;
    private String overview;
    private String urlPosterPath;
    private String fistAirDate;

    //Details Atributes
    //private int seasons;
    //private List<String> seasonsOverview;
    //private List<String> genres;
    //private String urlHomePage;
    //private int numberSeasons;
    //private int numberEpsodes;


    //Constructor
    public Serie(int id, String name, String originalName, String overview, String urlPosterPath, String fistAirDate) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.overview = overview;
        this.urlPosterPath = urlPosterPath;
        this.fistAirDate = fistAirDate;
    }

    //Constructor no parameters
    public Serie() {
    }

    //Starter getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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

    public String getFistAirDate() {
        return fistAirDate;
    }

    public void setFistAirDate(String fistAirDate) {
        this.fistAirDate = fistAirDate;
    }
}
