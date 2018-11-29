package com.example.manoel.maratoneia1.DataBase;

public class SerieIntro {

    private String name;
    private String poster;
    private int id;
    public SerieIntro(String name,String poster,int id){
        this.name = name;
        this.poster = poster;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
