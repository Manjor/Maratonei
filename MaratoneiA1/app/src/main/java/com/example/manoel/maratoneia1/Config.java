package com.example.manoel.maratoneia1;

public class Config {


    public static String URL_API = "https://api.themoviedb.org/3/";
    public static String URL_IMAGE_500 = "https://image.tmdb.org/t/p/w500";
    public static String URL_IMAGE_300 = "https://image.tmdb.org/t/p/w300";
    public static String URL_YOUTUBE = "https://www.youtube.com/watch?v=";
    public static String API_KEY = "f814673a004bcd3dfd0e837cf1a0b020";

    public static final String GOOGLE_API_KEY = "AIzaSyDD2ms4lXPrQuI8GT7YmvmRPskx2VkVUjE";


    public static String getDetailsMovie(int movieId, String language) {
        return URL_API + "movie/" + movieId + "?api_key=" + API_KEY + "&" + language;
    }

    public static String getVideo(int id, String language) {
        return URL_API + "movie/" + id + "/videos?api_key=" + API_KEY + "&" + language;
    }

    public static String getDetailsSerie(int serieId, String language) {
        return URL_API + "tv/" + serieId + "?api_key=" + API_KEY + "&" + language;
    }

    public static String getMoviePopular(String language) {
        return URL_API + "movie/popular" + "?api_key=" + API_KEY + "&page=1" + "&" + language;
    }

    public static String getMovieNowPlayng(String language) {
        return URL_API + "movie/now_playing" + "?api_key=" + API_KEY + "&page=1" + "&" + language;
    }

//    public static String getMovieByGenre(int genre, String language) {
//        return URL_API + "genre/" + genre + "/movies?api_key=" + API_KEY + "&page=1" + "&" + language;
//    }

    public static String getSeriePopular(String language) {
        return URL_API + "tv/popular" + "?api_key=" + API_KEY + "&page=1" + "&" + language;
    }

    public static String getPeopleMovie(int id, String language) {
        return URL_API + "movie/" + id + "/casts?api_key=" + API_KEY + "&" + language;
    }

    public static String getSeason(int tvId, int seasonNumber, String language) {
        return URL_API + "tv/" + tvId + "/season/" + seasonNumber + "?api_key=" + API_KEY + "&" + language;
    }

    public static String getSearch(String search, String language) {
        return URL_API + "search/multi?api_key=" + API_KEY + "&" + language + "&query=" + search;
    }
}
