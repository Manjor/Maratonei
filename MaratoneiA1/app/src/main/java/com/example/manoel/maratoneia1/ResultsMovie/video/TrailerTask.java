package com.example.manoel.maratoneia1.ResultsMovie.video;

import android.os.AsyncTask;

import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.MovieDetail;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TrailerTask extends AsyncTask<String,Void,Trailer> {

    private Trailer trailer = null;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private DetailsMovieActivity movieActivity = null;

    public TrailerTask(DetailsMovieActivity detailsMovieActivity){
        this.movieActivity = detailsMovieActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Trailer doInBackground(String... strings) {
        try{
            request = new Request.Builder().url(strings[0]).build();
            response = client.newCall(request).execute();
            String json = response.body().string();
            trailer = gson.fromJson(json, Trailer.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        return trailer;
    }

    @Override
    protected void onPostExecute(Trailer trailer) {
        super.onPostExecute(trailer);
        this.movieActivity.setThrailer(trailer);
    }
}
