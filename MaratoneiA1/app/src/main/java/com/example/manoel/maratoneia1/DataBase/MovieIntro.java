package com.example.manoel.maratoneia1.DataBase;

public class MovieIntro
{
    private String title;
    private String backdrop;
    private int id;
    public MovieIntro(String title,String backdrop,int id){
        this.title = title;
        this.backdrop = backdrop;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
