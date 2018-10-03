package com.example.manoel.maratoneia1;

import android.util.Log;

public class Configuracao {


    public static String urlApi = "https://api.themoviedb.org/3/";
    public static String urlImageApi = "https://image.tmdb.org/t/p/w500";
    public static String urlVideoApi = "";
    public static String apiKey = "f814673a004bcd3dfd0e837cf1a0b020";


    public String getDetailsMovie(int movieId, String language ){

        String result = this.urlApi + "movie/" + movieId + "?api_key=" + apiKey + "&" +language;
        Log.i("INFO","INFO - Result:" +result);
        return result;
    }

    public String getDetailsSerie(int serieId, String language){
        return this.urlApi + "tv/" + serieId + "?api_key=" + apiKey + "&" + language;
    }

    public static String getMoviePopular(String language){
        return urlApi + "movie/popular" + "?api_key=" + apiKey + "&page=1" + "&" + language;
    }


}
