package com.example.manoel.maratoneia1;

public class Configuracao {


    public static String urlApi = "https://api.themoviedb.org/3/";
    public static String urlImageApi = "https://image.tmdb.org/t/p/w500";
    public static String urlVideoApi = "";
    public static String apiKey = "f814673a004bcd3dfd0e837cf1a0b020";

    public String getDetailsMovie(int movieId, String language ){

        return this.urlApi + "movia/" + movieId + "?api_key=" + apiKey + "&" +language;
    }

    public String getDetailsSerie(int serieId, String language){
        return this.urlApi + "movia/" + serieId + "?api_key=" + apiKey + "&" + language;
    }

}
