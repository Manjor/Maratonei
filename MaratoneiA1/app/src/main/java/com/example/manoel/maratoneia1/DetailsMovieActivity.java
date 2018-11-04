package com.example.manoel.maratoneia1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.ResultsMovie.MovieTask;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.DetailsMovieTask;
import com.example.manoel.maratoneia1.ResultsMovie.detailsMovie.MovieDetail;
import com.squareup.picasso.Picasso;

public class DetailsMovieActivity extends AppCompatActivity {
    private String urlMovieDetails = null;
    private int id =0;
    private ImageView imageBackdrop = null;
    private ImageView imagePoster = null;
    private TextView textTitle = null;
    private TextView textDate = null;
    private Button btnGenre1 = null;
    private Button btnGenre2 = null;
    private Button btnGenre3 = null;
    private TextView textOverview = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        this.id = this.getIntent().getIntExtra("id",0);
        urlMovieDetails = Configuracao.getDetailsMovie(id,getResources().getString(R.string.language));
        imageBackdrop = findViewById(R.id.backdropDetailsMovie);
        imagePoster = findViewById(R.id.posterDetailsMovie);
        textTitle = findViewById(R.id.textDetailsMovieTitle);
        textDate = findViewById(R.id.textDetailsMovieDate);
        textOverview = findViewById(R.id.textDetailsMovieOverview);
        btnGenre1 = findViewById(R.id.btngenre1);
        btnGenre2 = findViewById(R.id.btngenre2);
        btnGenre3 = findViewById(R.id.btngenre3);

        DetailsMovieTask detailsMovieTask = new DetailsMovieTask(this);
        detailsMovieTask.execute(urlMovieDetails);


    }

    public void setData(MovieDetail movieDetail){
        //Set images
        Picasso.get().load(Configuracao.urlImageApi + movieDetail.getBackdropPath()).into(imageBackdrop);
        Picasso.get().load(Configuracao.urlImageApi + movieDetail.getPosterPath()).into(imagePoster);

        //Set texts
        textTitle.setText(movieDetail.getTitle());
        textDate.setText(movieDetail.getReleaseDate());
        textOverview.setText(movieDetail.getOverview());

        //Set genres
        if(movieDetail.getGenres().size() < 3){
            btnGenre2.setText(movieDetail.getGenres().get(0).getName());
            btnGenre1.setVisibility(View.INVISIBLE);
            btnGenre3.setVisibility(View.INVISIBLE);
        }
        else{
            btnGenre1.setText(movieDetail.getGenres().get(0).getName());
            btnGenre2.setText(movieDetail.getGenres().get(1).getName());
            btnGenre3.setText(movieDetail.getGenres().get(2).getName());

        }

    }
}
