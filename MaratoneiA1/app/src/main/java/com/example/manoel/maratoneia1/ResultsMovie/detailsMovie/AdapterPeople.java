package com.example.manoel.maratoneia1.ResultsMovie.detailsMovie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.ResultsMovie.people.Cast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPeople extends RecyclerView.Adapter<HolderPeople> {

    private ArrayList<Cast> casts = null;

    public AdapterPeople(ArrayList<Cast> casts) {
        this.casts = casts;
    }

    @NonNull
    @Override
    public HolderPeople onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_card, (ViewGroup) viewGroup.getParent(), false);
        return new HolderPeople(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPeople holderPeople, int i) {
        Cast cast = this.casts.get(i);
        holderPeople.getMovieName().setText(cast.getCharacter());
        holderPeople.getRealName().setText(cast.getName());
        Picasso.get().load(Config.URL_IMAGE_300 + cast.getProfilePath()).into(holderPeople.getImageProfile());
    }

    @Override
    public int getItemCount() {
        if (this.casts.size() > 6) {
            return 6;
        } else {

            return this.casts.size();
        }
    }
}
