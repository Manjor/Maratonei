package com.example.manoel.maratoneia1;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class Configuracao {


    public static String urlApi = "https://api.themoviedb.org/3/";
    public static String urlImageApi500 = "https://image.tmdb.org/t/p/w500";
    public static String urlImageApi300 = "https://image.tmdb.org/t/p/w300";
    public static String urlYoutube = "https://www.youtube.com/watch?v=";
    public static String apiKey = "f814673a004bcd3dfd0e837cf1a0b020";

    public static final String GOOGLE_API_KEY = "AIzaSyDD2ms4lXPrQuI8GT7YmvmRPskx2VkVUjE";


    public static String getDetailsMovie(int movieId, String language) {
        return urlApi + "movie/" + movieId + "?api_key=" + apiKey + "&" + language;
    }

    public static String getTrailer(String key) {
        return urlYoutube + key;
    }

    public static String getVideo(int id, String language) {
        return urlApi + "movie/" + id + "/videos?api_key=" + apiKey + "&" + language;
    }

    public static String getDetailsSerie(int serieId, String language) {
        return urlApi + "tv/" + serieId + "?api_key=" + apiKey + "&" + language;
    }

    public static String getMoviePopular(String language) {
        return urlApi + "movie/popular" + "?api_key=" + apiKey + "&page=1" + "&" + language;
    }

    public static String getMovieNowPlayng(String language) {
        return urlApi + "movie/now_playing" + "?api_key=" + apiKey + "&page=1" + "&" + language;
    }

    public static String getMovieByGenre(int genre, String language) {
        return urlApi + "genre/" + genre + "/movies?api_key=" + apiKey + "&page=1" + "&" + language;
    }

    public static String getSeriePopular(String language) {

        return urlApi + "tv/popular" + "?api_key=" + apiKey + "&page=1" + "&" + language;
    }

    public static String getPeopleMovie(int id, String language) {
        return urlApi + "movie/" + id + "/casts?api_key=" + apiKey + "&" + language;
    }

    public static String getSeason(int tvId, int seasonNumber, String language) {
        return urlApi + "tv/" + tvId + "/season/" + seasonNumber + "?api_key=" + apiKey + "&" + language;
    }
}
