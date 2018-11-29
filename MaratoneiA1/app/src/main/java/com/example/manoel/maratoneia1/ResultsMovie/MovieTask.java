package com.example.manoel.maratoneia1.ResultsMovie;

import android.os.AsyncTask;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
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

    private ArrayList<ResultMovie> movieList = null;
    private DataMovie resultRequest = null;
    private LottieAnimationView lottieAnimationView = null;

    MovieFragment movieFragment;

    public MovieTask(MovieFragment fragment, LottieAnimationView lottieAnimationView) {
        this.movieFragment = fragment;
        this.lottieAnimationView = lottieAnimationView;
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
        movieList = (ArrayList<ResultMovie>) resultRequest.getResults();

        return resultRequest;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        lottieAnimationView.setVisibility(View.INVISIBLE);
        lottieAnimationView.playAnimation();
    }

    @Override
    protected void onPostExecute(DataMovie dataMovie) {

        super.onPostExecute(dataMovie);

        ArrayList<ResultMovie> results = new ArrayList<>();

        results = (ArrayList<ResultMovie>) dataMovie.getResults();

        movieFragment.setAdapeter(results);
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(View.INVISIBLE);
    }

}
