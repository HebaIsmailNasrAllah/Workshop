package com.example.workshopapp.localData.viewModel.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.model.ArticlesItem

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleItem(articlesItem: ArticlesItem?)
    @Query("SELECT * FROM article_list")
    fun getAllArticles():LiveData<List<ArticlesItem>>
}