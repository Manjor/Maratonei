package com.example.manoeltoj.maratoneikotlin.Movie.dataMovie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Date{

    @SerializedName("maximum")
    @Expose
    var maximum:String? = null
        get() = field
        set(value) {field =value}
    @SerializedName("minimum")
    @Expose
    var minimun:String? = null
        get() = field
        set(value){
            field = value
        }


}