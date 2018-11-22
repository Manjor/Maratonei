package com.example.manoel.maratoneia1.Search;

import android.os.AsyncTask;

import com.example.manoel.maratoneia1.Search.searchResult.ResultSearch;
import com.example.manoel.maratoneia1.Search.searchResult.Search;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchTask extends AsyncTask<String,Void,Search> {

    private OkHttpClient clientHttp = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private ArrayList<ResultSearch> dataSearch = null;
    private Search resultRequest = null;
    private SeachActivity seachActivity = null;

    public SearchTask(SeachActivity seachActivity){
        this.seachActivity = seachActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Search doInBackground(String... strings) {
        try{
            dataSearch = new ArrayList<>();
            request = new Request.Builder().url(strings[0]).build();
            response = clientHttp.newCall(request).execute();
            String json = response.body().string();
            resultRequest = gson.fromJson(json, Search.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        return resultRequest;
    }

    @Override
    protected void onPostExecute(Search search) {
        super.onPostExecute(search);
        dataSearch = (ArrayList<ResultSearch>) search.getResults();
        this.seachActivity.setData(this.dataSearch);
    }
}
