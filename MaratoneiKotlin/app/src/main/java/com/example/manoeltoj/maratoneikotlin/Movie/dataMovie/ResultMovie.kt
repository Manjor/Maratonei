package com.example.manoeltoj.maratoneikotlin.Movie.dataMovie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultMovie{
    @SerializedName("poster_path")
    @Expose
    var posterPath:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("adult")
    @Expose
    var adult:Boolean? = null
        get() = field
        set(value){field = value}
    @SerializedName("overview")
    @Expose
    var overview:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("release_date")
    @Expose
    var releaseDate:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("genre_ids")
    @Expose
    var genreIds:List<Integer>? = null
        get() = field
        set(value){field = value}
    @SerializedName("id")
    @Expose
    var id:Integer? = null
        get() = field
        set(value){field = value}
    @SerializedName("original_title")
    @Expose
    var originalTitle:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("original_language")
    @Expose
    var originalLanguage:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("title")
    @Expose
    var title:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath:String? = null
        get() = field
        set(value){field = value}
    @SerializedName("popularity")
    @Expose
    var popularity:Double? = null
    @SerializedName("vote_count")
    @Expose
    var voteCount:Integer? = null
    @SerializedName("video")
    @Expose
    var video:Boolean? = null
        get() = field
        set(value){field = value}
    @SerializedName("vote_average")
    @Expose
    var voteAverage:Double? = null
        get() = field
        set(value){field = value}
}