package com.example.manoel.maratoneia1.ResultsMovie.people;

import android.os.AsyncTask;

import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieTask;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PeopleTask extends AsyncTask<String, Void,PeopleMovie> {

    private OkHttpClient client = new OkHttpClient();
    private Response response = null;
    private PeopleMovie peopleMovie = null;
    private Request request = null;
    private Gson gson = new Gson();
    private DetailsMovieActivity activity = null;

    public PeopleTask(DetailsMovieActivity activity){
        this.activity = activity;
    }
    @Override
    protected PeopleMovie doInBackground(String... strings) {


        try{
            request = new Request.Builder().url(strings[0]).build();
            response = client.newCall(request).execute();
            String json = response.body().string();
            peopleMovie = gson.fromJson(json,PeopleMovie.class);

        }catch (Exception error){

        }
        return peopleMovie;
    }

    @Override
    protected void onPostExecute(PeopleMovie peopleMovie) {
        super.onPostExecute(peopleMovie);
        this.activity.setPeople(peopleMovie.getCast());
    }

}
