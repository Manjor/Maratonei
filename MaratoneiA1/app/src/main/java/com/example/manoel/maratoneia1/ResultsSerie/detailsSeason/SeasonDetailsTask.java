package com.example.manoel.maratoneia1.ResultsSerie.detailsSeason;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.MovieDetail;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.SeasonDetail;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSerie.DetailsSerieActivity;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SeasonDetailsTask extends AsyncTask<String, Void, SeasonDetail> {

    private SeasonDetail seasonDetail = null;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private DetailsSerieActivity detailsSerieActivity = null;

    private Activity activity;

    public SeasonDetailsTask(DetailsSerieActivity activity) {
        this.detailsSerieActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected SeasonDetail doInBackground(String... strings) {

        try {
            request = new Request.Builder().url(strings[0]).build();
            response = client.newCall(request).execute();
            String json = response.body().string();
            seasonDetail = gson.fromJson(json, SeasonDetail.class);

        } catch (Exception e) {
            System.out.println("Error in processing request");
        }
        return seasonDetail;
    }

    @Override
    protected void onPostExecute(SeasonDetail seasonDetail) {
        super.onPostExecute(seasonDetail);
        this.detailsSerieActivity.setSeasonDetails(seasonDetail.getEpisodes());
    }
}
