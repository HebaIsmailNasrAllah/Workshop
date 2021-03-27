package com.example.workshopapp.repo

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.localData.ApiObjDataBase
import com.example.workshopapp.localData.viewModel.Dao.ArticlesDao

class NewsLocalDataSource (application: Application):NewsInterface{
    lateinit var articlesDao: ArticlesDao
    init {
        articlesDao=ApiObjDataBase.getDatabase(application).articlesDao()
    }
    override suspend fun insertArticleItem(articlesItem: ArticlesItem?) {
        articlesDao.insertArticleItem(articlesItem)
    }

    override fun getAllArticles(): LiveData<List<ArticlesItem>> {
        return articlesDao.getAllArticles()
    }

}