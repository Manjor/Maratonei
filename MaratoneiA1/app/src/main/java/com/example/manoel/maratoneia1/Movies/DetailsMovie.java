package com.example.manoel.maratoneia1.Movies;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.R;
import com.squareup.picasso.Picasso;

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

public class DetailsMovie  extends AppCompatActivity{


    //Atributes
    private ImageView movieBackdrop;
    private ImageView moviePoster;
    private VideoView movieVideo;
    private TextView movieTitle;
    private TextView movieOverview;
    private TextView movieDate;
    private TextView movieHomePage;

    private String urlPoster = null;
    private String urlBackdrop = null;
    private String overview = null;
    private String title = null;
    private String date = null;
    private String homepage = null;
    private String video = null;
    private String retorno = null;

    private String urlDetails = "";
    private String urlVideo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        getSupportActionBar().hide();

        movieBackdrop = findViewById(R.id.movieBackdrop);
        moviePoster = findViewById(R.id.moviePoster);
        movieVideo = findViewById(R.id.movieVideo);
        movieTitle = findViewById(R.id.movieTitle);
        movieOverview = findViewById(R.id.movieOverview);
        movieDate = findViewById(R.id.movieDate);
        movieHomePage = findViewById(R.id.movieHomePage);

        int movieId = this.getIntent().getIntExtra("id",0);

        Configuracao configuracao = new Configuracao();
        urlDetails = configuracao.getDetailsMovie(movieId, getResources().getString(R.string.language).toString());
        urlVideo = Configuracao.urlApi + "movie/" + movieId + "/videos" + "?api_key=" + Configuracao.apiKey + getResources().getString(R.string.language);

        MyTask task = new MyTask();
        MyTask task1 = new MyTask();

        task1.execute(urlVideo);
        task.execute(urlDetails);

    }
    class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stringUrl = strings[0];

            StringBuffer buffer = new StringBuffer();

            if(stringUrl.contains(urlVideo))
            {
                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;


                try {
                    URL url = new URL(stringUrl);
                    //Faz a requisição, abre a conexão
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                    //Recupera os dados em Bytes
                    inputStream = conexao.getInputStream();

                    //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                    inputStreamReader = new InputStreamReader(inputStream);

                    //Objeto utilizado para leitura dos caracteres do InputStreamReader
                    BufferedReader reader = new BufferedReader(inputStreamReader);


                    String linha = "";

                    while ((linha = reader.readLine()) != null) {

                        buffer.append(linha);
                    }

                    JSONArray jsonArray = null;
                    try {
                        JSONObject jsonObject = new JSONObject(buffer.toString());
                        jsonArray = jsonObject.getJSONArray("results");

                        JSONObject posicao = jsonArray.getJSONObject(0);
                        video = posicao.getString("key").toString();
                        retorno = "1";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("INFO","Segundo Processamento Realizado: " + urlVideo);
            }
            if(stringUrl.contains(urlDetails)){

                InputStream inputStream = null;
                InputStreamReader inputStreamReader = null;


                try {
                    URL url = new URL(stringUrl);
                    //Faz a requisição, abre a conexão
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                    //Recupera os dados em Bytes
                    inputStream = conexao.getInputStream();

                    //inputStreamReader lê os dados em Bytes e decodifica para caracteres
                    inputStreamReader = new InputStreamReader(inputStream);

                    //Objeto utilizado para leitura dos caracteres do InputStreamReader
                    BufferedReader reader = new BufferedReader(inputStreamReader);


                    String linha = "";

                    while ((linha = reader.readLine()) != null) {

                        buffer.append(linha);
                    }

                    try {
                        JSONObject jsonObject = new JSONObject(buffer.toString());

                        urlPoster = jsonObject.getString("poster_path");

                        urlBackdrop = jsonObject.getString("backdrop_path");

                        overview = jsonObject.getString("overview");
                        title = jsonObject.getString("title");
                        date = jsonObject.getString("release_date");
                        homepage = jsonObject.getString("homepage");

                        retorno = "2";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //return buffer.toString();
            return retorno;

        }

        @Override
        protected void onPostExecute(String resultado) {

            super.onPostExecute(resultado);

            try{
                if (retorno.contains("1")) {
                    Uri src = Uri.parse(video);
                    movieVideo.setVideoURI(src);
                }

                if (retorno.contains("2")) {
                    movieTitle.setText(title);
                    movieDate.setText(date);
                    movieOverview.setText(overview);
                    movieHomePage.setText("Homepage: " + homepage);
                    Picasso.get().load(Configuracao.urlImageApi + urlPoster).into(moviePoster);
                    Picasso.get().load(Configuracao.urlImageApi + urlBackdrop).into(movieBackdrop);
                }
            }catch (Exception e)
            {
                Log.i("INFO", "Erro no processamento de componentes");
            }

        }
    }
}
