package com.example.manoel.prototipomaratonei.FragmentsMain;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.prototipomaratonei.AdaptersFragments.SeriesAdapter;
import com.example.manoel.prototipomaratonei.Class.Serie;
import com.example.manoel.prototipomaratonei.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SeriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private static List<Serie> serieList = new ArrayList<>();
    View view;

    //Declare the Api base links
    private String baseApi = "https://api.themoviedb.org/3/";
    private String baseApiImage = "https://image.tmdb.org/t/p/w500";
    private String language = "&language=pt-BR";
    private String apiKey = "f814673a004bcd3dfd0e837cf1a0b020";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_series,container,false);
        recyclerView = view.findViewById(R.id.recycleSeries);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);


        recyclerView.setLayoutManager(linearLayoutManager);
        executaUrlAP();

        return view;
    }

    public void executaUrlAP()
    {
        String urlConsultSeries = this.baseApi + "tv/on_the_air?api_key=" + this.apiKey +
                "&page=1" + this.language;
        MyTask task = new MyTask();
        task.execute(urlConsultSeries);
    }

    //Mathod that add a new serie in list of series
    public void addSerie(int id, String name, String originalName, String overview, String urlPosterPath, String fistAirDate)
    {
        Serie serie = new Serie(id,name,originalName,overview,urlPosterPath,fistAirDate);
        serieList.add(serie);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public List<Serie> getSerieList() {
        return serieList;
    }

    public void setSerieList(List<Serie> serieList) {
        this.serieList = serieList;
    }


    public class MyTask extends AsyncTask<String,Void,String> {

        String results_api = null;
        String nameSerie = null;
        JSONArray jsonArray = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;

            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);

                //Make the request, open the connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();



                //Retunr the data in Bytes
                inputStream = connection.getInputStream();

                //inputStreamReader read the data in Bytes and decode the caracters
                inputStreamReader = new InputStreamReader( inputStream );

                //Object for reader of caracters of the InputStreamReader
                BufferedReader reader = new BufferedReader( inputStreamReader );

                buffer = new StringBuffer();
                String row = "";

                while(( row = reader.readLine()) != null ){

                    buffer.append( row );
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);


            //Execute processing of url in JSON format
            try {
                JSONObject jsonObject = new JSONObject(results);
                //busca no resultado json o array de chave - results
                jsonArray = jsonObject.getJSONArray("results");
                Log.i("INFO",jsonArray.toString());
                for(int i = 0; i< jsonArray.length(); i++){

                    JSONObject serie = jsonArray.getJSONObject(i);

                    int idSerie = serie.getInt("id");
                    String nameSerieJson = serie.getString("name");
                    String nameOriginalJson = serie.getString("original_name");
                    String overviewJson = serie.getString("overview");
                    String backdropPathJson = serie.getString("poster_path");
                    String fistAirDateJson = serie.getString("first_air_date");
                    String urlImage = baseApiImage + backdropPathJson;
                    addSerie(idSerie,nameSerieJson,nameOriginalJson,overviewJson,urlImage,fistAirDateJson);
                }
            }
            catch (JSONException exception){
                exception.printStackTrace();
            }

            SeriesAdapter seriesAdapter = new SeriesAdapter(serieList);
            recyclerView.setAdapter(seriesAdapter);
        }



    }
}
