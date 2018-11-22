package com.example.manoel.maratoneia1.Search;

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
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.Episode;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSerie.DetailsSerieActivity;
import com.example.manoel.maratoneia1.Search.searchResult.ResultSearch;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSearch extends RecyclerView.Adapter<SearchHolder> implements View.OnClickListener {

    private ArrayList<ResultSearch> resultSearchArrayList;
    private int id = 0;
    private String type = "";

    public AdapterSearch(ArrayList<ResultSearch> resultSearchArrayList) {
        this.resultSearchArrayList = resultSearchArrayList;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemList = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_card, (ViewGroup) viewGroup.getParent(), false);
        return new SearchHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder searchHolder, int i) {
        ResultSearch resultSearch = this.resultSearchArrayList.get(i);
        Picasso.get().load(Configuracao.urlImageApi300 + resultSearch.getPosterPath()).into(searchHolder.getPosterPath());
        this.type = resultSearch.getMediaType();
        this.id = resultSearch.getId();
        searchHolder.getPosterPath().setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return this.resultSearchArrayList.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.posterSearch){
            if(this.type.contains("tv")){
                Intent intent = new Intent(v.getContext(),DetailsSerieActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra("id",this.id);
                v.getContext().startActivity(intent);
            }
            if(this.type.contains("movie")){
                Intent intent = new Intent(v.getContext(),DetailsMovieActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra("id",this.id);
                v.getContext().startActivity(intent);
            }
        }
    }
}
