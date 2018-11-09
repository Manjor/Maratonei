package com.example.manoel.maratoneia1.Movies;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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
import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.DataBase.DataBaseOffline;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsMovie.MovieTask;
import com.example.manoel.maratoneia1.ResultsMovie.ResultMovie;
import com.example.manoel.maratoneia1.WelcomeActivity;

import java.util.ArrayList;

public class MovieFragment extends Fragment implements View.OnClickListener {


    View view;

    private RecyclerView recyclerViewEmCartaz;
    private RecyclerView recyclerViewCategory;
    private LottieAnimationView lottieLoader;
    private Button btnNowPlay;
    private Button btnAction;
    private Button btnAventure;
    private Button btnComedy;
    private Button btnRomance;
    private Button btnWar;
    private Button btnMistery;
    private String urlAirPlaying;
    private String urlCategory;
    private MovieTask movieTask;
    private DataBaseOffline dataBaseOffline = null;
    private ArrayList<ResultMovie> resultMovies = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_movies, container, false);

        recyclerViewEmCartaz = view.findViewById(R.id.reclyclerMovie);
        lottieLoader = view.findViewById(R.id.lottieLoader);
        urlAirPlaying = Configuracao.getMovieNowPlayng(getResources().getString(R.string.language));
        urlCategory = Configuracao.getMoviePopular(getResources().getString(R.string.language));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewEmCartaz.setLayoutManager(layoutManager);

        if (MainActivity.Connection == false) {

            resultMovies = new ArrayList<>();
            dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);
            for (int i = 0; i < dataBaseOffline.getItensMovieIntro().size(); i++) {
                resultMovies.add(new ResultMovie(dataBaseOffline.getItensMovieIntro().get(i).getTitle(), dataBaseOffline.getItensMovieIntro().get(i).getBackdrop()));
            }
            MovieAdapterCategory movieAdapter = new MovieAdapterCategory(resultMovies);
            recyclerViewEmCartaz.setAdapter(movieAdapter);
        } else {
            movieTask = new MovieTask(this, lottieLoader);
            movieTask.execute(urlCategory);
        }
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
        return view;
    }

    public void setAdapeter(ArrayList<ResultMovie> movies) {

        dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);

        for (int i = 0; i < movies.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", movies.get(i).getTitle());
            contentValues.put("backdrop", movies.get(i).getBackdropPath());
            this.dataBaseOffline.insertMovieIntro(contentValues);
        }
        int size = dataBaseOffline.getItensMovieIntro().size();
        String itens = dataBaseOffline.getItensMovieIntro().toString();

        MovieAdapterCategory movieAdapter = new MovieAdapterCategory(movies);
        recyclerViewEmCartaz.setAdapter(movieAdapter);
    }

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

}
