package com.example.workshopapp.repo

import androidx.lifecycle.LiveData
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.localData.FavavouriteItem

interface NewsInterface {
    suspend fun insertArticleItem(articlesItem: ArticlesItem?)
    fun getAllArticles(): LiveData<List<ArticlesItem>>
    fun insertFavourite(favavouriteItem: FavavouriteItem)
    fun getAllFavourites():LiveData<List<FavavouriteItem>>
    fun deleteFavouriteItem(favavouriteItem: FavavouriteItem)
}