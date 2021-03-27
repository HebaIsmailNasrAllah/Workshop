package com.example.workshopapp.repo

import androidx.lifecycle.LiveData
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.NewsResponse

interface RemoteInterface {
    fun fetchNewsData(apiKey:String,lang:String,source:String):LiveData<NewsResponse>
}