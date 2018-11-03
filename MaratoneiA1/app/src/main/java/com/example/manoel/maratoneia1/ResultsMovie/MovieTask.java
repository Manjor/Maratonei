package com.example.manoel.maratoneia1.ResultsMovie;

import android.os.AsyncTask;

import com.example.manoel.maratoneia1.Movies.MovieAdapterCategory;
import com.example.manoel.maratoneia1.Movies.MovieFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieTask extends AsyncTask<String,Void,DataMovie> {

    private OkHttpClient clientHttp = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private MovieAdapterCategory adapterCategory;

    private ArrayList<Result> movieList = null;
    private DataMovie resultRequest = null;
    MovieFragment movieFragment = null;

    public MovieTask(MovieFragment fragment) {
        this.movieFragment = fragment;
    }
    @Override
    protected DataMovie doInBackground(String... strings) {
        try{
            movieList = new ArrayList<>();
            request = new Request.Builder().url(strings[0]).build();
            response = clientHttp.newCall(request).execute();
            String json = response.body().string();
            resultRequest = gson.fromJson(json, DataMovie.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        movieList = (ArrayList<Result>) resultRequest.getResults();

        return resultRequest;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(DataMovie dataMovie) {

        super.onPostExecute(dataMovie);

        ArrayList<Result> results = new ArrayList<>();

        results = (ArrayList<Result>) dataMovie.getResults();

        movieFragment.setAdapeter(results);
    }

}
