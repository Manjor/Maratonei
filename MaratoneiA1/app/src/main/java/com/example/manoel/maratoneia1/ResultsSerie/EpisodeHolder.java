package com.example.manoel.maratoneia1.ResultsSerie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;

public class EpisodeHolder extends RecyclerView.ViewHolder {

    private TextView episodename;
    private TextView episodeOverview;
    public EpisodeHolder(@NonNull View itemView) {
        super(itemView);
        this.episodename = itemView.findViewById(R.id.textEpsode);
        this.episodeOverview = itemView.findViewById(R.id.textEpsodeOverview);
    }

    public TextView getEpisodename() {
        return episodename;
    }

    public void setEpisodename(TextView episodename) {
        this.episodename = episodename;
    }

    public TextView getEpisodeOverview() {
        return episodeOverview;
    }

    public void setEpisodeOverview(TextView episodeOverview) {
        this.episodeOverview = episodeOverview;
    }
}
