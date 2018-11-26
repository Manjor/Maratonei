package com.example.manoeltoj.maratoneikotlin.Movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView

import com.example.manoeltoj.maratoneikotlin.Config

class MovieFragment:Fragment(),View.OnClickListener{



    lateinit var recyclerView:RecyclerView
    lateinit var lottieLoader:LottieAnimationView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    //var resultMovies:ArrayList<>
    override fun onClick(v: View?) {

    }

}