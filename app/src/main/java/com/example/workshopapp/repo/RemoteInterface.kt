package com.example.workshopapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.NewsResponse

interface RemoteInterface {
    suspend fun fetchNewsData(apiKey:String,q:String): List<ArticlesItem?>?
}