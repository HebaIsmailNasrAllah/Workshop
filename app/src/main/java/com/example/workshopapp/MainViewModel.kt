package com.example.workshopapp

import android.app.Application
import androidx.lifecycle.*
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.NewsResponse
import com.example.workshopapp.localData.FavavouriteItem
import com.example.workshopapp.repo.NewsRepo
import com.example.workshopapp.repo.RemoteDataSource
import kotlinx.coroutines.launch

class MainViewModel(application: Application):AndroidViewModel (application){
    var newsRepo:NewsRepo
    init {
        newsRepo= NewsRepo(application)
    }
    val liveData=newsRepo.getData()
    fun fetchNewsData(apiKey: String,q:String){
        viewModelScope.launch {
             newsRepo.refresh(apiKey,q)
        }

    }
    fun insertfavouriteItem(favavouriteItem: FavavouriteItem){
        viewModelScope.launch {
            newsRepo.insertFavourite(favavouriteItem)
        }
    }
}