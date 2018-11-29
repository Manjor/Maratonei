package com.example.manoel.maratoneia1.Series;

import android.content.ContentValues;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.DataBase.DataBaseOffline;
import com.example.manoel.maratoneia1.DataBase.SerieIntro;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsSerie.ResultSerie;
import com.example.manoel.maratoneia1.ResultsSerie.SerieTask;

import java.util.ArrayList;

public class SerieFragment extends Fragment{

    View view;

    private RecyclerView recyclerView;
    private LottieAnimationView lottieLoad;
    private DataBaseOffline dataBaseOffline = null;
    private ArrayList<SerieIntro> serieIntros = null;
    private ArrayList<SerieIntro> resultSeries = null;

    private RecyclerView.LayoutManager layoutManager = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_series, container, false);

        recyclerView = view.findViewById(R.id.reclyclerSerie);
        lottieLoad = view.findViewById(R.id.lottieLoaderSerie);
        lottieLoad.setVisibility(View.INVISIBLE);
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        if (MainActivity.CONNECTION == false) {
            resultSeries = new ArrayList<>();
            dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);
            resultSeries = this.dataBaseOffline.getItensSerieIntro();
            SerieAdapter serieAdapter = new SerieAdapter(resultSeries);
            recyclerView.setAdapter(serieAdapter);
        } else {
            SerieTask serieTask = new SerieTask(this, lottieLoad);
            serieTask.execute(Config.getSeriePopular(getResources().getString(R.string.language)));
        }
        return view;

    }

    public void setAdapter(ArrayList<ResultSerie> series) {

        dataBaseOffline = new DataBaseOffline(getContext(), "movie", 1);

        this.dataBaseOffline.clearSeries();
        for (int i = 0; i < series.size(); i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", series.get(i).getName());
            contentValues.put("poster", series.get(i).getPosterPath());
            contentValues.put("idserie", series.get(i).getId());

            this.dataBaseOffline.insertSerieIntro(contentValues);
        }

        int size = dataBaseOffline.getItensSerieIntro().size();
        String itens = dataBaseOffline.getItensSerieIntro().toString();

        serieIntros = this.dataBaseOffline.getItensSerieIntro();

        SerieAdapter serieAdapter = new SerieAdapter(serieIntros);
        recyclerView.setAdapter(serieAdapter);

    }

}
