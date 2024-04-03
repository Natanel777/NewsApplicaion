package natanel.android.newsapplication.data.api

import androidx.multidex.BuildConfig
import natanel.android.newsapplication.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val MY_API_KEY = "" //need to add it!! TODO(ENTER YOUR API_KEY)
//Our Endpoints from Retrofit.http
interface ApiService {


    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = MY_API_KEY
    ): Response<NewsResponse>
}

//GET https://newsapi.org/v2/top-he