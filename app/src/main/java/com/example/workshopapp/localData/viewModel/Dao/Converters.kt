package com.example.workshopapp.localData.viewModel.Dao

import androidx.room.TypeConverter
import com.example.newsapp.model.ArticlesItem
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun  listOfArticlesToJson (value:List<ArticlesItem>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToArticleList(value: String) = Gson().fromJson(value, Array<ArticlesItem>::class.java).toList()
}