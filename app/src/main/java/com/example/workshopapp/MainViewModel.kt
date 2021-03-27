package com.example.workshopapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.newsapp.model.NewsResponse
import com.example.workshopapp.repo.RemoteDataSource

class MainViewModel(application: Application):AndroidViewModel (application){
    var apiRepository:RemoteDataSource
    init {
        apiRepository= RemoteDataSource()
    }
    fun fetchNewsData(apiKey: String,q:String):LiveData<NewsResponse>{
        return apiRepository.fetchNewsData(apiKey,q)
    }
}