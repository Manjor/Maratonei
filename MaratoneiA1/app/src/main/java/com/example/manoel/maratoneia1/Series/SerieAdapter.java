package com.example.manoel.maratoneia1.Series;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieActivity;
import com.example.manoel.maratoneia1.ResultsSerie.ResultSerie;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSerie.DetailsSerieActivity;
import com.example.manoel.maratoneia1.WelcomeActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieHolder>{

    private List<ResultSerie> serieList = null;



    public SerieAdapter(List<ResultSerie> serieList){
        this.serieList = serieList;
    }

    @NonNull
    @Override
    public SerieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.serie_card,parent,false);

        return new SerieHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieHolder holder, int position) {
        final ResultSerie serie = serieList.get(position);
        final int id = serie.getId();
        try{
            Picasso.get().load(Configuracao.urlImageApi500 + serie.getPosterPath()).into(holder.getSeriePosterPath());
        }catch (Exception e){

        }

        holder.getSeriePosterPath().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailsSerieActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra("id",id);

                v.getContext().startActivity(intent);

//                BottomSheetDetails bottom = new BottomSheetDetails(v.getContext());
//                bottom.setTitle("Resumo");
//                bottom.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.serieList.size();
    }
}
