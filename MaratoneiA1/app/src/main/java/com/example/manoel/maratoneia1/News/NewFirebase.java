package com.example.manoel.maratoneia1.News;

public class NewFirebase {
    private String title;
    private String description;
    private String date;
    private String autorName;

    public NewFirebase(){}

    public NewFirebase(String title, String description, String date, String autorName) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.autorName = autorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }
}
