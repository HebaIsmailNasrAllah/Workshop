package com.example.workshopapp.repo

import androidx.lifecycle.LiveData
import com.example.newsapp.model.ArticlesItem

interface NewsInterface {
    suspend fun insertArticleItem(articlesItem: ArticlesItem?)
    fun getAllArticles(): LiveData<List<ArticlesItem>>
}