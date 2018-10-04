package com.example.manoel.maratoneia1.News;

public class New {

    private String newImageProfile;
    private String newTitle;
    private String newDate;
    private String newDesc;
    private String newImage;
    private String newVideo;
    private int keyVideo;

    public New() {
    }

    public New(String newImageProfile,String newTitle, String newDate, String newDesc, String newImage) {
        this.newImageProfile = newImageProfile;
        this.newTitle = newTitle;
        this.newDate = newDate;
        this.newDesc = newDesc;
        this.newImage = newImage;
    }
    public New(String newImageProfile,String newTitle, String newDate, String newDesc, String newVideo, int keyVideo){
        this.newImageProfile = newImageProfile;
        this.newTitle = newTitle;
        this.newDate = newDate;
        this.newDesc = newDesc;
        this.newVideo = newVideo;
        this.keyVideo = keyVideo;
    }

    public String getNewImageProfile() {
        return newImageProfile;
    }

    public void setNewImageProfile(String newImageProfile) {
        this.newImageProfile = newImageProfile;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
    }

    public String getNewDesc() {
        return newDesc;
    }

    public void setNewDesc(String newDesc) {
        this.newDesc = newDesc;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public String getNewVideo() {
        return newVideo;
    }

    public void setNewVideo(String newVideo) {
        this.newVideo = newVideo;
    }

    public int getKeyVideo() {
        return keyVideo;
    }

    public void setKeyVideo(int keyVideo) {
        this.keyVideo = keyVideo;
    }
}
