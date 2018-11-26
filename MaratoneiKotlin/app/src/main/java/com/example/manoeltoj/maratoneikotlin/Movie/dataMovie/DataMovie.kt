package com.example.manoeltoj.maratoneikotlin.Movie.dataMovie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataMovie{
    @SerializedName("page")
    @Expose
    var page:Integer? = null
        get() = field
        set(value){
            field = value
        }
    @SerializedName("results")
    @Expose
    var results:List<ResultMovie>? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("date")
    @Expose
    var date:Date? = null
        get() = field
        set(value) {field = value}
    @SerializedName("total_pages")
    @Expose
    var totalPages:Integer? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("total_results")
    @Expose
    var totalResults:Integer? =null
        get() = field
        set(value) {
            field = value
        }
}