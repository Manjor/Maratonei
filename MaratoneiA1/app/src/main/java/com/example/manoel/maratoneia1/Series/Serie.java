package com.example.manoel.maratoneia1.Series;

public class Serie {

    private String serieName;
    private String serieImage;
    private int serieId;

    public Serie(){}
    public Serie(String serieName, String serieImage, int serieId) {
        this.serieName = serieName;
        this.serieImage = serieImage;
        this.serieId = serieId;
    }


    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public String getSerieImage() {
        return serieImage;
    }

    public void setSerieImage(String serieImage) {
        this.serieImage = serieImage;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }
}
