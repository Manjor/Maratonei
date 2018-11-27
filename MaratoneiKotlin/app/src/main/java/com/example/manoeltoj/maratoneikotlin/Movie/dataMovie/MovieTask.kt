package com.example.manoeltoj.maratoneikotlin.Movie.dataMovie

import android.os.AsyncTask
import com.example.manoeltoj.maratoneikotlin.Movie.MovieAdapter
import com.example.manoeltoj.maratoneikotlin.Movie.MovieFragment
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.lang.Exception

class MovieTask(fragment: MovieFragment): AsyncTask<String, Void, DataMovie>() {

    var clientHttp: OkHttpClient = OkHttpClient()
    var gson: Gson = Gson()
    lateinit var response:Response
    lateinit var request: Request
    lateinit var movieAdapter: MovieAdapter
    lateinit var movieList: ArrayList<ResultMovie>
    lateinit var resultData: DataMovie
    lateinit var movieFragment: MovieFragment


    init {
        this.movieFragment = fragment
    }
    override fun doInBackground(vararg params: String?): DataMovie {
        try {
            movieList = ArrayList()
            request = Request.Builder().url(params[0]).build()
            response = clientHttp.newCall(request).execute()
            var json:String = response.body()?.string() ?: ""
            resultData = gson.fromJson(json,DataMovie::class.java)
        }catch (e:Exception){
            println("Erro in processing URL")
        }
        return resultData
    }

    override fun onPostExecute(result: DataMovie?) {
        super.onPostExecute(result)
        movieList = resultData.results as ArrayList<ResultMovie>
        movieFragment.setData(movieList)
    }

}