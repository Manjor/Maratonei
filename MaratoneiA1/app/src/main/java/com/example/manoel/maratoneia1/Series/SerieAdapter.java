package com.example.manoel.maratoneia1.Series;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.DataBase.SerieIntro;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSerie.DetailsSerieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieHolder> {

//    private List<ResultSerie> serieList = null;
//    public SerieAdapter(List<ResultSerie> serieList){
//        this.serieList = serieList;
//    }

    private List<SerieIntro> serieIntros = null;

    public SerieAdapter(List<SerieIntro> serieIntros) {
        this.serieIntros = serieIntros;
    }

    @NonNull
    @Override
    public SerieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.serie_card, parent, false);

        return new SerieHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull SerieHolder holder, int position) {
        final SerieIntro serie = serieIntros.get(position);
        final int id = serie.getId();
        try {
            Picasso.get().load(Config.URL_IMAGE_300 + serie.getPoster()).into(holder.getSeriePosterPath());
        } catch (Exception e) {
            System.out.println("Erro ao processar as imagens");
        }

        holder.getSeriePosterPath().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (MainActivity.CONNECTION == false) {
                    Toast toast = Toast.makeText(v.getContext(), "Não foi possível conectar a internet, por favor, verifique sua conexão e tente novamente mais tarde.", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intent = new Intent(v.getContext(), DetailsSerieActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtra("id", id);

                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.serieIntros.size();
    }
}
