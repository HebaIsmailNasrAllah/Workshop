package com.example.workshopapp.repo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.ArticlesItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsRepo(application: Application) {
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var newsLocalDataSource: NewsLocalDataSource
    init {
        remoteDataSource= RemoteDataSource()
        newsLocalDataSource= NewsLocalDataSource(application)
    }
     fun getData():LiveData<List<ArticlesItem>>{


        return newsLocalDataSource.getAllArticles()
    }
    suspend fun refresh(apiKey: String,
                        q:String){
        val articlesList=remoteDataSource.fetchNewsData(apiKey,q)

        if (articlesList != null){
            articlesList.forEach {
                newsLocalDataSource.insertArticleItem(it)
            }

        }
    }

}