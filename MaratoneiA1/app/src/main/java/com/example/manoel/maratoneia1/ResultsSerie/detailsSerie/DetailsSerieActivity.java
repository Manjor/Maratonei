package com.example.manoel.maratoneia1.ResultsSerie.detailsSerie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Configuracao;
import com.example.manoel.maratoneia1.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsSerieActivity extends AppCompatActivity {

    private String urlSerieDetail = null;
    private int id = 0;
    private ImageView imageBackdrop = null;
    private ImageView imagePoster = null;
    private TextView textName = null;
    private TextView textRelease = null;
    private TextView genre = null;
    private TextView textOverview = null;
    private List<Season> seasons = null;

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
            //Set genres
            if (serieDetail.getGenres().size() >= 1) {
                genre.setText(serieDetail.getGenres().get(0).getName());
            } else {
                genre.setVisibility(View.INVISIBLE);
                genre.setEnabled(false);
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Desculpe. O Filme indisponível.", Toast.LENGTH_LONG).show();
            this.finish();
        }

    }
}
