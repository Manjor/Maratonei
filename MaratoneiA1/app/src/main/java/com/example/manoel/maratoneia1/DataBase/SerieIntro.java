package com.example.manoel.maratoneia1.DataBase;

public class SerieIntro {

    private String name;
    private String poster;
    public SerieIntro(String name,String poster){
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
