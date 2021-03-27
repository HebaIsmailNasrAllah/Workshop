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
     var newsLiveData:MutableLiveData<List<ArticlesItem>> = MutableLiveData()
    override suspend fun fetchNewsData(
        apiKey: String,
        q:String
    ): List<ArticlesItem?>? {

         val response = ApiClient.getApi().getNews(apiKey,q)
            try {
                if (response.isSuccessful) {
                   return response.body()?.articles
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        return null
    }

}