package com.example.manoel.maratoneia1.Series;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.ResultsSerie.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieHolder>{

    private List<Result> serieList = null;



    public SerieAdapter(List<Result> serieList){
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
        final Result serie = serieList.get(position);

        //holder.getSerieName().setText(serie.getName());
        final int id = serie.getId();
        try{

        Picasso.get().load(Configuracao.urlImageApi500 + serie.getPosterPath()).into(holder.getSerieBackdrop());
        }catch (Exception e){

        }

//        holder.getSerieBackdrop().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent it = new Intent(view.getContext(),DetailsSerie.class);
//                Bundle bundle = new Bundle();
//
//                it.putExtra("id", id);
//
//                view.getContext().startActivity(it);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.serieList.size();
    }
}
