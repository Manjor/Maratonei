package com.example.manoel.maratoneia1.DataBase;

public class MovieIntro
{
    private String title;
    private String backdrop;
    public MovieIntro(String title,String backdrop){
        this.title = title;
        this.backdrop = backdrop;
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
}
