package com.example.manoel.maratoneia1.ResultsMovie.detailsMovie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dataMovie.manoel.maratoneia1.R;
import com.example.manoel.maratoneia1.Config;
import com.example.manoel.maratoneia1.ResultsMovie.people.Cast;
import com.example.manoel.maratoneia1.ResultsMovie.people.PeopleTask;
import com.example.manoel.maratoneia1.ResultsMovie.video.Trailer;
import com.example.manoel.maratoneia1.ResultsMovie.video.TrailerTask;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailsMovieActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String urlMovieDetails = null;
    private int id =0;
    private ImageView imageBackdrop = null;
    private ImageView imagePoster = null;
    private TextView textTitle = null;
    private TextView textDate = null;
    private TextView genre = null;
    private TextView star = null;
    private TextView textOverview = null;
    private List<Cast> casts = null;
    private RecyclerView recyclerPeople = null;
    private YouTubePlayerView youTubePlayer = null;
    private Trailer trailer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);


        this.id = this.getIntent().getIntExtra("id",0);
        urlMovieDetails = Config.getDetailsMovie(id,getResources().getString(R.string.language));
        imageBackdrop = findViewById(R.id.backdropDetailsMovie);
        imagePoster = findViewById(R.id.posterDetailsMovie);
        textTitle = findViewById(R.id.textDetailsMovieTitle);
        textDate = findViewById(R.id.textDetailsMovieDate);
        textOverview = findViewById(R.id.textDetailsMovieOverview);
        genre = findViewById(R.id.textDetailsMovieGenre);
        //star = findViewById(R.id.textStars);
        youTubePlayer = findViewById(R.id.movieYoutubePlayer);


        recyclerPeople = findViewById(R.id.recyclerPeaple);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerPeople.setLayoutManager(layoutManager);

        DetailsMovieTask detailsMovieTask = new DetailsMovieTask(this);
        detailsMovieTask.execute(urlMovieDetails);

        PeopleTask peopleTask = new PeopleTask(this);
        peopleTask.execute(Config.getPeopleMovie(this.id,getResources().getString(R.string.language)));

        TrailerTask trailerTask = new TrailerTask(this);
        trailerTask.execute(Config.getVideo(this.id,getResources().getString(R.string.language)));
    }

    public void setData(MovieDetail movieDetail){
        try{
            try{
                //Set images
                Picasso.get().load(Config.URL_IMAGE_500 + movieDetail.getBackdropPath()).into(imageBackdrop);
                Picasso.get().load(Config.URL_IMAGE_500 + movieDetail.getPosterPath()).into(imagePoster);
            }catch (Exception e ){

            }
            try{
                //Set texts
                textTitle.setText(movieDetail.getTitle());
                textDate.setText("Estréia: " +movieDetail.getReleaseDate());
                textOverview.setText(movieDetail.getOverview());
                star.setText(movieDetail.getVoteAverage().toString());
            }catch (Exception e){

            }

            try{
                //Set genres
                if(movieDetail.getGenres().size() >= 1){
                    genre.setText(movieDetail.getGenres().get(0).getName());
                }
                else {
                    genre.setVisibility(View.INVISIBLE);
                    genre.setEnabled(false);
                }
            }catch (Exception e){

            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Desculpe. O Filme indisponível.",Toast.LENGTH_LONG).show();
            //this.finish();
        }

    }
    public void setThrailer(Trailer trailer){
        try{
            this.trailer = trailer;
            youTubePlayer.initialize(Config.GOOGLE_API_KEY,this);
        }
        catch (Exception e){
            youTubePlayer.setVisibility(View.INVISIBLE);
            youTubePlayer.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Trailer Não Encontrado.",Toast.LENGTH_LONG).show();
        }

    }

    public void setPeople(List<Cast> casts){
        try{
            this.casts = new ArrayList<>();
            this.casts = casts;
            AdapterPeople adapterPeople = new AdapterPeople((ArrayList<Cast>) this.casts);
            recyclerPeople.setAdapter(adapterPeople);
        }catch (Exception e){
            this.recyclerPeople.setVisibility(View.INVISIBLE);
            this.recyclerPeople.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Elenco Indisponível para esse Filme.",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        try{
            String url = Config.URL_YOUTUBE + this.trailer.getResults().get(0).getKey();
            youTubePlayer.cueVideo(this.trailer.getResults().get(0).getKey());
        }catch (Exception e){
            this.youTubePlayer.setVisibility(View.INVISIBLE);
            this.youTubePlayer.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Trailer Não Encontrado.",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplicationContext(),"Não foi possível encontrar um trailer para esse filme.",Toast.LENGTH_LONG).show();
    }
}
