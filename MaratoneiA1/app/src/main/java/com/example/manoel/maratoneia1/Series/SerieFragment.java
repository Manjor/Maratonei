package com.example.manoel.maratoneia1.Series;

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

public class SerieFragment extends Fragment {

    View view;

    private RecyclerView recyclerView;
    private List<Serie> serieList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_serie,container,false);

        recyclerView = view.findViewById(R.id.recycleSerie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

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
        }

        @Override
        protected String doInBackground(String... strings) {


            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;

            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);
                //Faz a requisição, abre a conexão
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();



                //Recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                inputStreamReader = new InputStreamReader( inputStream );

                //Objeto utilizado para leitura dos caracteres do InputStreamReader
                BufferedReader reader = new BufferedReader( inputStreamReader );

                buffer = new StringBuffer();
                String linha = "";

                while(( linha = reader.readLine()) != null ){

                    buffer.append( linha );
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            String results = null;
            String nomeSerie = null;
            JSONArray jsonArray = null;

            try {
                JSONObject jsonObject = new JSONObject(resultado);
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
                e.printStackTrace();
            }

            SerieAdapter seriesAdapter = new SerieAdapter( serieList );

            recyclerView.setAdapter(seriesAdapter);

            Log.i("INFO","JSON: " + jsonArray.toString());


        }
    }
}
