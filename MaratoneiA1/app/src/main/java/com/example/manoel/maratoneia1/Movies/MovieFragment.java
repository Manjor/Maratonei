package com.example.manoel.maratoneia1.Movies;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Series.Serie;
import com.example.manoel.maratoneia1.Series.SerieAdapter;

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
import java.util.EventListener;
import java.util.List;

public class MovieFragment extends Fragment implements View.OnClickListener {


    View view;

    private RecyclerView recyclerView;
    private List<Movie> movieList;
    private LottieAnimationView lottieLoad;
    private Button btnNowPlay;
    private Button btnAction;
    private Button btnTriller;
    private Button btnWar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_movie,container,false);

        recyclerView = view.findViewById(R.id.recycleMovie);
        lottieLoad = view.findViewById(R.id.lottieLoadMovie);
        btnNowPlay = view.findViewById(R.id.btnNowPlay);
        btnNowPlay.setOnClickListener(this);

        btnAction = view.findViewById(R.id.btnAction);
        btnAction.setOnClickListener(this);

        btnTriller = view.findViewById(R.id.btnTriller);
        btnTriller.setOnClickListener(this);

        btnWar = view.findViewById(R.id.btnWar);
        btnWar.setOnClickListener(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        chamaTask(Configuracao.getMoviePopular(getResources().getString(R.string.language).toString()));

        return view;
    }
    public void chamaTask(String request){

        MyTask task = new MyTask();
        task.execute(request);

    }

    public void adicionaMovieCard(String movieTitle,String movieBackdrop, int id)
    {
        Movie movie = new Movie(movieTitle, movieBackdrop ,id);
        this.movieList.add(movie);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNowPlay:
                chamaTask(Configuracao.getMovieNowPlayng(getResources().getString(R.string.language)));
                break;
            case R.id.btnAction:
                chamaTask(Configuracao.getMovieByGenre(28,getResources().getString(R.string.language)));
                break;
            case R.id.btnTriller:
                chamaTask(Configuracao.getMovieByGenre(12,getResources().getString(R.string.language)));
                break;
        }
    }

    class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            lottieLoad.playAnimation();
        }

        @Override
        protected String doInBackground(String... strings) {
            movieList = new ArrayList<>();
            String stringUrl = strings[strings.length - 1];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;

            StringBuffer buffer = null;
            Log.i("INFO","String doInBackground"+ stringUrl);

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
                String results = null;
                String nomeSerie = null;
                JSONArray jsonArray = null;

                try {
                    JSONObject jsonObject = new JSONObject(buffer.toString());
                    jsonArray = jsonObject.getJSONArray("results");

                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject e = jsonArray.getJSONObject(i);
                        String strinJsonNomeSerie = e.getString("title");
                        String backdropJsonSerie = e.getString("backdrop_path");
                        int idJsonSerie = e.getInt("id");
                        String urlImagemBanner = Configuracao.urlImageApi + backdropJsonSerie;

                        adicionaMovieCard(strinJsonNomeSerie,urlImagemBanner,idJsonSerie);
                    }

                } catch (JSONException e) {
                    //e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                //e.printStackTrace();

            } catch (IOException e) {
                Toast.makeText(getContext(),"Os componentes não podem ser iniciados", Toast.LENGTH_SHORT).show();
                //e.printStackTrace();
            }


            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            lottieLoad.cancelAnimation();
            lottieLoad.setVisibility(View.INVISIBLE);
            super.onPostExecute(resultado);
            Log.i("INFO","Tamnho do Lista: " + movieList.size());

            MovieAdapter movieAdapter = new MovieAdapter( movieList );
            recyclerView.setAdapter(movieAdapter);
        }
    }
}
