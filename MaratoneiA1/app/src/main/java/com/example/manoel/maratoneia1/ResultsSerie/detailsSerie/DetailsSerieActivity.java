package com.example.manoel.maratoneia1.ResultsSerie.detailsSerie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.MainActivity;
import com.example.manoel.maratoneia1.ResultsSerie.AdapterEpisode;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.Episode;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.SeasonDetail;
import com.example.manoel.maratoneia1.ResultsSerie.detailsSeason.SeasonDetailsTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailsSerieActivity extends AppCompatActivity{

    private String urlSerieDetail = null;
    private int id = 0;
    private ImageView imageBackdrop = null;
    private ImageView imagePoster = null;
    private TextView textName = null;
    private TextView textRelease = null;
    private TextView genre = null;
    private TextView textOverview = null;
    private Spinner spinnerSeasons = null;
    private RecyclerView recyclerEpisode = null;
    SeasonDetailsTask seasonDetailsTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_serie);
        this.id = getIntent().getIntExtra("id", 0);
        this.imageBackdrop = findViewById(R.id.backdropDetailsSerie);
        this.imagePoster = findViewById(R.id.posterDetailsSerie);
        this.textName = findViewById(R.id.textDetailsSerieName);
        this.textRelease = findViewById(R.id.textDetailsSerieRelease);
        this.genre = findViewById(R.id.textDetailsSerieGenre);
        this.textOverview = findViewById(R.id.textDetailsSerieOverview);
        this.spinnerSeasons = findViewById(R.id.spinnerSeasons);
        this.recyclerEpisode = findViewById(R.id.recyclerEpsodes);
        DetailsSerieTask detailsSerieTask = new DetailsSerieTask(this);
        detailsSerieTask.execute(Configuracao.getDetailsSerie(id, getResources().getString(R.string.language)));
        this.seasonDetailsTask = new SeasonDetailsTask(this);

    }

    public void setData(SerieDetail serieDetail) {
        try {
            //Set images
            Picasso.get().load(Configuracao.urlImageApi500 + serieDetail.getBackdropPath()).into(imageBackdrop);
            Picasso.get().load(Configuracao.urlImageApi500 + serieDetail.getPosterPath()).into(imagePoster);
            //Set texts
            this.textName.setText(serieDetail.getName());
            this.textRelease.setText("Primeira vez no ar: " + serieDetail.getFirstAirDate());
            this.textOverview.setText(serieDetail.getOverview());
            List<Season> seasons = serieDetail.getSeasons();
            List<String> numberSeasons = new ArrayList<>();
            for(int i = 0; i < seasons.size(); i++){
                numberSeasons.add(seasons.get(i).getSeasonNumber() + "ª Temporada");
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,android.R.layout.simple_spinner_item,
                    numberSeasons
            );
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerSeasons.setAdapter(arrayAdapter);
            this.spinnerSeasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("INFO", "SELECIONADO: " + spinnerSeasons.getSelectedItemPosition());
                }
            });
            //Set genres
            if (serieDetail.getGenres().size() >= 1) {
                genre.setText(serieDetail.getGenres().get(0).getName());
            } else {
                genre.setVisibility(View.INVISIBLE);
                genre.setEnabled(false);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Desculpe. Serie indisponível.", Toast.LENGTH_LONG).show();
        }
    }

    public void setSeasonDetails(SeasonDetail seasonDetails){
        AdapterEpisode adapterEpisode = new AdapterEpisode((ArrayList<Episode>) seasonDetails.getEpisodes());
        this.recyclerEpisode.setAdapter(adapterEpisode);
    }
}
