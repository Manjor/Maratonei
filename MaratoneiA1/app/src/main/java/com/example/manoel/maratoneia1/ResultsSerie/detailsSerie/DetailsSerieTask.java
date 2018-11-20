package com.example.manoel.maratoneia1.ResultsSerie.detailsSerie;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.MovieDetail;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailsSerieTask extends AsyncTask<String,Void,SerieDetail>{

    private SerieDetail serieDetail = null;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private DetailsSerieActivity detailsSerieActivity = null;

    private Activity activity;
    public DetailsSerieTask(DetailsSerieActivity activity){
        this.detailsSerieActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected SerieDetail doInBackground(String... strings) {

        try{
            this.request = new Request.Builder().url(strings[0]).build();
            this.response = client.newCall(request).execute();
            String json = response.body().string();
            this.serieDetail = gson.fromJson(json, SerieDetail.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        return this.serieDetail;
    }

    @Override
    protected void onPostExecute(SerieDetail serieDetail) {
        super.onPostExecute(serieDetail);
        this.detailsSerieActivity.setData(serieDetail);
    }
}
