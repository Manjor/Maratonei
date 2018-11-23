package com.example.manoeltoj.maratoneikotlin

class Config {
    companion object {
        val URL_API: String = "https://api.themoviedb.org/3/"
        val URL_IMAGE_500: String = "https://image.tmdb.org/t/p/w500"
        val URL_IMAGE_300: String = "https://image.tmdb.org/t/p/w300"
        val URL_YOUTUBE = "https://www.youtube.com/watch?v="
        val API_KEY = "f814673a004bcd3dfd0e837cf1a0b020"
        val GOOGLE_API_KEY = "AIzaSyDD2ms4lXPrQuI8GT7YmvmRPskx2VkVUjE"

        fun getDetailsMovie(movieId: Int, language: String): String {
            return "${URL_API}movie/${movieId}?api_key=${API_KEY}&${language}"
        }

        fun getDetailsSerie(serieId: Int, language: String): String {
            return "${URL_API}tv/${serieId}?api_key=${API_KEY}&${language}"
        }

        fun getMoviePopular(language: String): String {
            return "${URL_API}movie/popular?api_key=${API_KEY}&page=1&${language}"
        }

        fun getMovieNowPlayng(language: String): String {
            return "${URL_API}movie/now_playing?api_key=${API_KEY}&page=1&${language}"
        }

        fun getSeriePopular(language: String): String {
            return "${URL_API}tv/popular?api_key=${API_KEY}&page=1&${language}"
        }

        fun getPeopleMovie(id: Int, language: String): String {
            return "${URL_API}movie/${id}/casts?api_key=${API_KEY}&${language}"
        }

        fun getSeason(tvId: Int, seasonNumber: Int, language: String): String {
            return "${URL_API}tv/${tvId}/season/${seasonNumber}?api_key=${API_KEY}&${language}"
        }

        fun getSearch(search: String, language: String): String {
            return "${URL_API}search/muilt?api_key=${API_KEY}&${language}"
        }
    }
}