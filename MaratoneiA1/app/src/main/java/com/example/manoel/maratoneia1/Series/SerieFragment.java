package com.example.manoel.maratoneia1.Series;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.R;

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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SerieFragment extends Fragment {

    View view;

    private RecyclerView recyclerView;
    private List<Serie> serieList;
    private LottieAnimationView lottieLoad;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_serie,container,false);

        recyclerView = view.findViewById(R.id.recycleSerie);
        lottieLoad = view.findViewById(R.id.lottieLoadSerie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);


        MyTask task = new MyTask();
        task.execute(Configuracao.getSeriePopular(getResources().getString(R.string.language)));

        return view;

    }

    public void adicionaSerieCard(String nomeSerie,String imagemSerie, int id)
    {
        Serie serie = new Serie(nomeSerie, imagemSerie ,id);
        this.serieList.add(serie);
    }



    class MyTask extends AsyncTask<String,Void,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            lottieLoad.playAnimation();
        }

        @Override
        protected String doInBackground(String... strings) {

            serieList = new ArrayList<>();
            String stringUrl = strings[0];

            String results = null;
            OkHttpClient client = new OkHttpClient();
            try {
                URL url = new URL(stringUrl);
                Request request = new Request.Builder().url(url).build();

                Response response = client.newCall(request).execute();

                results = response.body().string();
                Log.i("INFO", "Result" + results);

            } catch (Exception e) {
                e.printStackTrace();
            }

            JSONArray jsonArray = null;

            try {
                JSONObject jsonObject = new JSONObject(results);
                jsonArray = jsonObject.getJSONArray("results");

                for(int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject e = jsonArray.getJSONObject(i);
                    String strinJsonNomeSerie = e.getString("name");
                    String backdropJsonSerie = e.getString("backdrop_path");
                    int idJsonSerie = e.getInt("id");
                    String urlImagemBanner = Configuracao.urlImageApi + backdropJsonSerie;
                    adicionaSerieCard(strinJsonNomeSerie,urlImagemBanner,idJsonSerie);
                }

            } catch (JSONException e) {
                Toast.makeText(getContext(),"Os componentes não podem ser iniciados", Toast.LENGTH_SHORT).show();
            }

            return results;
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            lottieLoad.cancelAnimation();
            lottieLoad.setVisibility(View.INVISIBLE);
            SerieAdapter seriesAdapter = new SerieAdapter( serieList );
            recyclerView.setAdapter(seriesAdapter);
        }
    }
}
