package com.example.manoel.maratoneia1.Series;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manoel.maratoneia1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieHolder>{

    private List<Serie> serieList;



    public SerieAdapter(List<Serie> serieList){
        this.serieList = serieList;
    }

    @NonNull
    @Override
    public SerieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_serie,parent,false);

        return new SerieHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieHolder holder, int position) {
        final Serie serie = serieList.get(position);

        holder.getSerieName().setText(serie.getSerieName());
        final int id = serie.getSerieId();
        Picasso.get().load(serie.getSerieImage()).into(holder.getSerieBackdrop());

        holder.getSerieBackdrop().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(view.getContext(),DetailsSerie.class);
                Bundle bundle = new Bundle();

                it.putExtra("id", id);

                view.getContext().startActivity(it);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.serieList.size();
    }
}
