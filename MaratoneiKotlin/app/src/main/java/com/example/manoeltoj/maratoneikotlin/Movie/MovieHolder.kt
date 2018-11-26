package com.example.manoeltoj.maratoneikotlin.Movie

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.manoeltoj.maratoneikotlin.R.id.imageBackdrop
import com.example.manoeltoj.maratoneikotlin.R.id.textTitle

class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var movieTitle:TextView
    var movieBackdrop:ImageView

    init {
        this.movieTitle = itemView.findViewById(textTitle)
        this.movieBackdrop = itemView.findViewById(imageBackdrop)
    }



}