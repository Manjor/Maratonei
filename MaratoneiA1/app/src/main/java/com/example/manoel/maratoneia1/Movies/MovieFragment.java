package com.example.manoel.maratoneia1.Movies;

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

import com.airbnb.lottie.LottieAnimationView;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.HandlerServices;
import com.example.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.ResultsMovie.Result;
import com.example.manoel.maratoneia1.movie.movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieFragment extends Fragment implements View.OnClickListener {


    View view;

    private RecyclerView recyclerViewEmCartaz;
    private RecyclerView recyclerViewCategory;
    private List<movie> movieList;
    private LottieAnimationView lottieLoad;
    private Button btnNowPlay;
    private Button btnAction;
    private Button btnAventure;
    private Button btnComedy;
    private Button btnRomance;
    private Button btnWar;
    private Button btnMistery;
    private String urlAirPlaying;
    private String urlCategory;
    private HandlerServices handlerServices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.movie_frag, container, false);

        recyclerViewEmCartaz = view.findViewById(R.id.recyclerAir);
        recyclerViewCategory = view.findViewById(R.id.reclyclerCategory);
        lottieLoad = view.findViewById(R.id.lottieLoading);
        urlAirPlaying = Configuracao.getMovieNowPlayng(getResources().getString(R.string.language));
        urlCategory = Configuracao.getMoviePopular(getResources().getString(R.string.language));
        handlerServices = new HandlerServices();

//
//        btnNowPlay = view.findViewById(R.id.btnNowPlay);
//        btnNowPlay.setOnClickListener(this);
//
//        btnAction = view.findViewById(R.id.btnAction);
//        btnAction.setOnClickListener(this);
//
//        btnAventure = view.findViewById(R.id.btnAventure);
//        btnAventure.setOnClickListener(this);
//
//        btnComedy = view.findViewById(R.id.btnComedy);
//        btnComedy.setOnClickListener(this);
//
//        btnRomance = view.findViewById(R.id.btnRomance);
//        btnRomance.setOnClickListener(this);
//
//        btnMistery = view.findViewById(R.id.btnMistery);
//        btnMistery.setOnClickListener(this);
//
//        btnWar = view.findViewById(R.id.btnWar);
//        btnWar.setOnClickListener(this);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEmCartaz.setLayoutManager(layoutManager);

//        ((LinearLayoutManager) layoutManager1).setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerViewCategory.setLayoutManager(layoutManager1);
        handlerServices.execute(this.urlAirPlaying);

//        MyTask task = new MyTask();
//        task.execute(this.urlAirPlaying);
        return view;
    }

    public void setAdapeter(ArrayList<Result> movies){
        MovieAdapterCategory movieAdapter = new MovieAdapterCategory(movies);
        recyclerViewEmCartaz.setAdapter(movieAdapter);
    }

//    public void adicionaMovieCard(String movieTitle, String movieBackdrop, int id) {
//        Movie movie = new Movie(movieTitle, movieBackdrop, id);
//        this.movieList.add(movie);
//    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnNowPlay:
//                chamaTask(Configuracao.getMovieNowPlayng(getResources().getString(R.string.language)));
//                break;
//            case R.id.btnAction:
//                chamaTask(Configuracao.getMovieByGenre(28, getResources().getString(R.string.language)));
//                break;
//            case R.id.btnAventure:
//                chamaTask(Configuracao.getMovieByGenre(12, getResources().getString(R.string.language)));
//                break;
//            case R.id.btnComedy:
//                chamaTask(Configuracao.getMovieByGenre(35, getResources().getString(R.string.language)));
//                break;
//            case R.id.btnRomance:
//                chamaTask(Configuracao.getMovieByGenre(10749, getResources().getString(R.string.language)));
//                break;
//            case R.id.btnMistery:
//                chamaTask(Configuracao.getMovieByGenre(9648, getResources().getString(R.string.language)));
//                break;
//            case R.id.btnWar:
//                chamaTask(Configuracao.getMovieByGenre(10752, getResources().getString(R.string.language)));
//                break;
//
//
//        }
    }

//    class MyTask extends AsyncTask<String, Void, String> {
//        private String results;
//        private JSONArray jsonArray;
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            lottieLoad.playAnimation();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            movieList = new ArrayList<>();
//            String stringUrl = strings[strings.length - 1];
//            processJson(stringUrl);
//            return results;
//        }
//
//        public void processJson(String stringUrl) {
//
//            OkHttpClient client = new OkHttpClient();
//            try {
//                URL url = new URL(stringUrl);
//                Request request = new Request.Builder().url(url).build();
//                Response response = client.newCall(request).execute();
//                this.results = response.body().string();
//
//
//                //variavel = vrGson.fromJson(sJSon, Company.class)
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                JSONObject jsonObject = new JSONObject(this.results);
//                this.jsonArray = jsonObject.getJSONArray("results");
//                for (int i = 0; i < this.jsonArray.length(); i++) {
//                    JSONObject e = this.jsonArray.getJSONObject(i);
//                    String strinJsonNomeSerie = e.getString("title");
//                    String imageMovie = "";
//                    int idJsonSerie = e.getInt("id");
//                    imageMovie = e.getString("backdrop_path");
//                    String urlImagemBanner = Configuracao.urlImageApi + imageMovie;
//                    adicionaMovieCard(strinJsonNomeSerie, urlImagemBanner, idJsonSerie);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String resultado) {
//            lottieLoad.cancelAnimation();
//            lottieLoad.setVisibility(View.INVISIBLE);
//            super.onPostExecute(resultado);
//            MovieAdapterCategory movieAdapter = new MovieAdapterCategory(movieList);
//            recyclerViewEmCartaz.setAdapter(movieAdapter);
//        }
//    }
}
