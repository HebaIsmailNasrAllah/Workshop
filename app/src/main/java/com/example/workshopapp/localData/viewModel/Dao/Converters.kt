package com.example.workshopapp.localData.viewModel.Dao

import androidx.room.TypeConverter
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.localData.FavavouriteItem
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun  listOfArticlesToJson (value:List<ArticlesItem>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToArticleList(value: String) = Gson().fromJson(value, Array<ArticlesItem>::class.java).toList()
    @TypeConverter
    fun  listOfFavouritesToJson (value:List<FavavouriteItem>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToFavouriteList(value: String) = Gson().fromJson(value, Array<FavavouriteItem>::class.java).toList()
}