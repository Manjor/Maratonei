package com.example.manoel.prototipomaratonei.AdaptersFragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.prototipomaratonei.Class.Serie;
import com.example.manoel.prototipomaratonei.HoldersFragments.SeriesHolder;
import com.example.manoel.prototipomaratonei.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesHolder> {

    private List<Serie> serieList;


    public SeriesAdapter(List<Serie> serieList){
        this.serieList = serieList;
    }


    //Ovierride methods of the class RecyclerView.Adapter
    @NonNull
    @Override
    public SeriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_serie,parent,false);
        return new SeriesHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SeriesHolder holder, int position) {

        Serie serie = serieList.get(position);
        Log.i("INFO",serie.getName().toString());
        Log.i("INFO",serie.getUrlPosterPath());
        Log.i("INFO",serie.getOriginalName());
        Log.i("INFO",serie.getOverview());
        Log.i("INFO","" + serie.getId());

        holder.getTxtSerie().setText(serie.getName());
        final int id = serie.getId();
        //Processa a Url da Imagem e Insere no ImagemView
        Picasso.get().load(serie.getUrlPosterPath()).into(holder.getImgSerie());

    }

    @Override
    public int getItemCount() {
        return serieList.size();
    }
}
