package com.example.manoel.maratoneia1.ResultsMovie.detailsMovie;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.manoel.maratoneia1.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.DataMovie;
import com.example.manoel.maratoneia1.ResultsMovie.Result;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailsMovieTask extends AsyncTask<String,Void,MovieDetail> {

    private MovieDetail movieDetail = null;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private DetailsMovieActivity movieActivity = null;

    public DetailsMovieTask(DetailsMovieActivity detailsMovieActivity){
        this.movieActivity = detailsMovieActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected MovieDetail doInBackground(String... strings) {
        try{
            request = new Request.Builder().url(strings[0]).build();
            response = client.newCall(request).execute();
            String json = response.body().string();
            movieDetail = gson.fromJson(json, MovieDetail.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        return movieDetail;
    }

    @Override
    protected void onPostExecute(MovieDetail movieDetail) {
        super.onPostExecute(movieDetail);
        this.movieActivity.setData(movieDetail);
    }

}
