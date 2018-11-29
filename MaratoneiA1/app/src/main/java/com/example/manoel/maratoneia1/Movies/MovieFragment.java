package com.example.manoel.maratoneia1.Movies;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.DataBase.DataBaseOffline;
import com.example.manoel.maratoneia1.DataBase.MovieIntro;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsMovie.MovieTask;
import com.example.manoel.maratoneia1.ResultsMovie.ResultMovie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {


    View view;

    private RecyclerView recyclerNowPlaying;
    private LottieAnimationView lottieLoader;
    private String urlAirPlaying;
    private String urlCategory;
    private MovieTask movieTask;
    private DataBaseOffline dataBaseOffline = null;
    private ArrayList<MovieIntro> resultMovies = null;
    ArrayList<MovieIntro> moviesIntro = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_movies, container, false);

        recyclerNowPlaying = view.findViewById(R.id.reclyclerMovie);
        lottieLoader = view.findViewById(R.id.lottieLoader);
        lottieLoader.setVisibility(View.INVISIBLE);
        urlAirPlaying = Config.getMovieNowPlayng(getResources().getString(R.string.language));
        urlCategory = Config.getMoviePopular(getResources().getString(R.string.language));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerNowPlaying.setLayoutManager(layoutManager);

        if (MainActivity.CONNECTION == false) {
            resultMovies = new ArrayList<>();
            dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);

            resultMovies = this.dataBaseOffline.getItensMovieIntro();
//            for (int i = 0; i < dataBaseOffline.getItensMovieIntro().size(); i++) {
//                resultMovies.add(new ResultMovie(dataBaseOffline.getItensMovieIntro().get(i).getTitle(), dataBaseOffline.getItensMovieIntro().get(i).getBackdrop()));
//            }
            MovieAdapterCategory movieAdapter = new MovieAdapterCategory(resultMovies);
            recyclerNowPlaying.setAdapter(movieAdapter);
        } else {
            movieTask = new MovieTask(this, lottieLoader);
            movieTask.execute(urlCategory);
        }
        return view;
    }

    public void setAdapeter(ArrayList<ResultMovie> movies) {

        dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);
        this.dataBaseOffline.clearMovies();
        for (int i = 0; i < movies.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", movies.get(i).getTitle());
            contentValues.put("backdrop", movies.get(i).getBackdropPath());
            contentValues.put("idmovie",movies.get(i).getId());
            this.dataBaseOffline.insertMovieIntro(contentValues);
        }
        int size = dataBaseOffline.getItensMovieIntro().size();
        String itens = dataBaseOffline.getItensMovieIntro().toString();
        moviesIntro = this.dataBaseOffline.getItensMovieIntro();
        MovieAdapterCategory movieAdapter = new MovieAdapterCategory(moviesIntro);
        recyclerNowPlaying.setAdapter(movieAdapter);
    }

}
