package com.example.manoel.maratoneia1.ResultsSerie.detailsSerie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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

public class DetailsSerieActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
    private List<Episode> episodes = null;
    List<Integer> numSeason = new ArrayList<>();

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

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerEpisode.setLayoutManager(layoutManager);

        DetailsSerieTask detailsSerieTask = new DetailsSerieTask(this);
        detailsSerieTask.execute(Configuracao.getDetailsSerie(id, getResources().getString(R.string.language)));


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
            this.numSeason = new ArrayList<>();
            for (int i = 0; i < seasons.size(); i++) {
                numberSeasons.add(seasons.get(i).getSeasonNumber() + "ª Temporada");
                numSeason.add(seasons.get(i).getSeasonNumber());
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item,
                    numberSeasons
            );
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerSeasons.setAdapter(arrayAdapter);
            this.spinnerSeasons.setOnItemSelectedListener(this);
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

    public void setSeasonDetails(List<Episode> episodes) {
        this.episodes = new ArrayList<>();
        this.episodes = episodes;
        AdapterEpisode adapterEpisode = new AdapterEpisode((ArrayList<Episode>) this.episodes);

        this.recyclerEpisode.setAdapter(adapterEpisode);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SeasonDetailsTask seasonDetailsTask  = new SeasonDetailsTask(this);
        seasonDetailsTask.execute(Configuracao.getSeason(this.id,this.numSeason.get(spinnerSeasons.getSelectedItemPosition()),getResources().getString(R.string.language)));
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}