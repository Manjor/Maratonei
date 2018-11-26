package com.example.manoeltoj.maratoneikotlin.Movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manoeltoj.maratoneikotlin.Config
import com.example.manoeltoj.maratoneikotlin.Movie.dataMovie.ResultMovie
import com.example.manoeltoj.maratoneikotlin.R.layout.movie_card
import com.squareup.picasso.Picasso

class MovieAdapter(movieList:ArrayList<ResultMovie>) : RecyclerView.Adapter<MovieHolder>() {
    var resultMovie:ResultMovie = ResultMovie()
    var movieList:ArrayList<ResultMovie>

    init {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieHolder {
        var itemList: View = LayoutInflater.from(p0.context).inflate(movie_card,p0,false)
        return MovieHolder(itemList)
    }

    override fun getItemCount(): Int {
        return this.movieList.size
    }

    override fun onBindViewHolder(p0: MovieHolder, p1: Int) {
        val movie:ResultMovie = movieList.get(p1)
        p0.movieTitle.setText(movie.title)
        val id: Integer? = movie.id
        try {
            Picasso.get().load(Config.URL_IMAGE_500 + movie.backdropPath).into(p0.movieBackdrop)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}