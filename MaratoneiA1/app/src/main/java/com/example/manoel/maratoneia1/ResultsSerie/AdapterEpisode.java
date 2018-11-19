package com.example.manoel.maratoneia1.ResultsSerie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.HolderPeople;
import com.example.manoel.maratoneia1.ResultsMovie.people.Cast;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.Episode;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterEpisode extends RecyclerView.Adapter<EpisodeHolder> {


    private ArrayList<Episode> episodes;

    public AdapterEpisode(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    @NonNull
    @Override
    public EpisodeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.epsode_card, (ViewGroup) viewGroup.getParent(), false);
        return new EpisodeHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeHolder epsodeHolder, int i) {
        Episode episode = this.episodes.get(i);
        epsodeHolder.getEpisodename().setText(episode.getEpisodeNumber()+ " " + episode.getName());
        epsodeHolder.getEpisodeOverview().setText(episode.getOverview());
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }
}
