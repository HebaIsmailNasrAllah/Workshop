package com.example.workshopapp.api

import com.example.newsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(@Query("apiKey") apiKey:String,
                @Query("q")q:String, ):Response<NewsResponse>
}