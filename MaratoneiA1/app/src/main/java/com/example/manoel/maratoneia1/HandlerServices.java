package com.example.manoel.maratoneia1;

import android.os.AsyncTask;

import com.example.manoel.maratoneia1.Movies.MovieAdapterCategory;
import com.example.manoel.maratoneia1.Movies.MovieFragment;
import com.example.manoel.maratoneia1.ResultsMovie.Example;
import com.example.manoel.maratoneia1.ResultsMovie.Result;
import com.example.manoel.maratoneia1.movie.movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HandlerServices extends AsyncTask<String,Void,Example> {

    private OkHttpClient clientHttp = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private MovieAdapterCategory adapterCategory;

    private ArrayList<Example> movieList = null;
    Type listType = new TypeToken<List<movie>>() {}.getType();

    private Example resultado = null;
    MovieFragment movieFragment = null;
    public HandlerServices() {
    }

    @Override
    protected Example doInBackground(String... strings) {

        try{
            movieList = new ArrayList<>();
            request = new Request.Builder().url(strings[0]).build();
            response = clientHttp.newCall(request).execute();
            String json = response.body().string();
//             json = json.substring("{'results':".length());
//             String json2 = json.substring(json.length() -1, json.length());
//            System.out.println(json);
//            System.out.println(json2);
             resultado = gson.fromJson(json, Example.class);

        }catch (Exception e){

        }

        return resultado;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Example example) {
        super.onPostExecute(example);
        ArrayList<Result> results = new ArrayList<>();
        results = (ArrayList<Result>) example.getResults();

        movieFragment.setAdapeter(results);
    }

}
