package com.example.manoeltoj.maratoneikotlin.Movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView

import com.example.manoeltoj.maratoneikotlin.Config
import com.example.manoeltoj.maratoneikotlin.MainActivity
import com.example.manoeltoj.maratoneikotlin.Movie.dataMovie.MovieTask
import com.example.manoeltoj.maratoneikotlin.Movie.dataMovie.ResultMovie
import com.example.manoeltoj.maratoneikotlin.R.layout.fragment_movies
import com.example.manoeltoj.maratoneikotlin.R.string.language
import kotlinx.android.synthetic.main.fragment_movies.*

class MovieFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var viewr: View
    lateinit var lottieLoader: LottieAnimationView
    lateinit var movieList: ArrayList<ResultMovie>
    var urlNowPlaying: String = "";
    lateinit var movieTask: MovieTask

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewr = inflater.inflate(fragment_movies, container, false)
        recyclerView = reclyclerMovie
        urlNowPlaying = Config.getMovieNowPlayng(resources.getString(language))

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        if (MainActivity.CONNECTION == false) {

        } else {
            movieTask = MovieTask(this)
            movieTask.execute(urlNowPlaying)
        }

        return viewr
    }
    fun setData(movieList: ArrayList<ResultMovie>) {
        this.movieList = movieList
        var movieAdapter:MovieAdapter = MovieAdapter(this.movieList)
        recyclerView.adapter = movieAdapter

    }

}