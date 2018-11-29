package com.example.manoel.maratoneia1.Movies;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.DataBase.DataBaseOffline;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsMovie.MovieTask;
import com.example.manoel.maratoneia1.ResultsMovie.ResultMovie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {


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
        urlAirPlaying = Config.getMovieNowPlayng(getResources().getString(R.string.language));
        urlCategory = Config.getMoviePopular(getResources().getString(R.string.language));

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

}
