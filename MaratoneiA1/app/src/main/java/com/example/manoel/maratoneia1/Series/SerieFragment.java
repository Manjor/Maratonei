package com.example.manoel.maratoneia1.Series;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.ResultsSerie.ResultSerie;
import com.example.manoel.maratoneia1.ResultsSerie.SerieTask;

import java.util.ArrayList;

public class SerieFragment extends Fragment {

    View view;

    private RecyclerView recyclerView;
    private LottieAnimationView lottieLoad;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_series,container,false);
        recyclerView = view.findViewById(R.id.reclyclerSerie);
        lottieLoad = view.findViewById(R.id.lottieLoaderSerie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager1);

        //recyclerView.setLayoutManager(layoutManager);
        SerieTask serieTask = new SerieTask(this,lottieLoad);
        serieTask.execute(Config.getSeriePopular(getResources().getString(R.string.language)));

        return view;

    }
    public void setAdapter(ArrayList<ResultSerie> series){
        SerieAdapter movieAdapter = new SerieAdapter(series);
        recyclerView.setAdapter(movieAdapter);
    }
}
