package com.example.manoel.maratoneia1.ResultsSerie;

import android.os.AsyncTask;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.manoel.maratoneia1.Series.SerieAdapter;
import com.example.manoel.maratoneia1.Series.SerieFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SerieTask extends AsyncTask<String,Void,DataSerie> {


    private OkHttpClient clientHttp = new OkHttpClient();
    private Gson gson = new Gson();
    private Response response = null;
    private Request request = null;
    private SerieAdapter serieAdapter;
    private ArrayList<DataSerie> dataSeries = null;
    private DataSerie resultRequest = null;
    SerieFragment serieFragment = null;
    LottieAnimationView lottieAnimationView = null;

    public SerieTask(SerieFragment serieFragment, LottieAnimationView lottieAnimationView){
        this.serieFragment = serieFragment;
        this.lottieAnimationView = lottieAnimationView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        lottieAnimationView.playAnimation();
    }

    @Override
    protected DataSerie doInBackground(String... strings) {
        try{
            dataSeries = new ArrayList<>();
            request = new Request.Builder().url(strings[0]).build();
            response = clientHttp.newCall(request).execute();
            String json = response.body().string();
            resultRequest = gson.fromJson(json, DataSerie.class);

        }catch (Exception e){
            System.out.println("Error in processing request");
        }
        return resultRequest;
    }

    @Override
    protected void onPostExecute(DataSerie dataSerie) {
        super.onPostExecute(dataSerie);
        ArrayList<Result> resultSeries = new ArrayList<>();
        resultSeries = (ArrayList<Result>) dataSerie.getResultSeries();

        serieFragment.setAdapter(resultSeries);
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(View.INVISIBLE);
    }


}
