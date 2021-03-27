package com.example.workshopapp.repo

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.localData.ApiObjDataBase
import com.example.workshopapp.localData.FavavouriteItem
import com.example.workshopapp.localData.viewModel.Dao.ArticlesDao
import com.example.workshopapp.localData.viewModel.Dao.FavouriteDao

class NewsLocalDataSource (application: Application):NewsInterface{
    lateinit var articlesDao: ArticlesDao
    lateinit var favouriteDao: FavouriteDao
    init {
        articlesDao=ApiObjDataBase.getDatabase(application).articlesDao()
        favouriteDao=ApiObjDataBase.getDatabase(application).favouriteDao()
    }
    override suspend fun insertArticleItem(articlesItem: ArticlesItem?) {
        articlesDao.insertArticleItem(articlesItem)
    }

    override fun getAllArticles(): LiveData<List<ArticlesItem>> {
        return articlesDao.getAllArticles()
    }

    override fun insertFavourite(favavouriteItem: FavavouriteItem) {
        favouriteDao.insertFavouriteItem(favavouriteItem)
    }

    override fun getAllFavourites(): LiveData<List<FavavouriteItem>> {
        return favouriteDao.getAllFavourites()
    }

    override fun deleteFavouriteItem(favavouriteItem: FavavouriteItem) {
        favouriteDao.deleteFavouriteItem(favavouriteItem)
    }


}