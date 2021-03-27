package com.example.workshopapp.api

import com.example.newsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    fun getNews(@Query("apiKey") apiKey:String,
                @Query("language")language:String,
                @Query("sources") source:String):Response<NewsResponse>
}