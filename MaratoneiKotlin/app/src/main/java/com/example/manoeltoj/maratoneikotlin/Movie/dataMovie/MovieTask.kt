package com.example.manoeltoj.maratoneikotlin.Movie.dataMovie

import android.os.AsyncTask
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MovieTask: AsyncTask<String, Void, DataMovie>() {

    var clientHttp: OkHttpClient = OkHttpClient()
    var gson: Gson =Gson()
    var response: Response? = null
    var request: Request?  = null;

    override fun doInBackground(vararg params: String?): DataMovie {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}