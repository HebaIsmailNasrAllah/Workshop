package com.example.workshopapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.NewsResponse
import com.example.workshopapp.api.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RemoteDataSource : RemoteInterface{
     var newsLiveData:MutableLiveData<NewsResponse> = MutableLiveData()
    override fun fetchNewsData(
        apiKey: String,
        q:String
    ): LiveData<NewsResponse> {
       CoroutineScope(Dispatchers.IO).launch {
            val response = ApiClient.getApi().getNews(apiKey,q)
            try {
                if (response.isSuccessful) {
                   newsLiveData.postValue(response.body())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return newsLiveData
    }

}