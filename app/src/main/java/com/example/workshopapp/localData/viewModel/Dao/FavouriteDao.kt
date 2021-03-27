package com.example.workshopapp.localData.viewModel.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.model.ArticlesItem
import com.example.workshopapp.localData.FavavouriteItem

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteItem(favavouriteItem: FavavouriteItem)
    @Query("SELECT * FROM favourite_list")
    fun getAllFavourites(): LiveData<List<FavavouriteItem>>
    @Delete
    fun deleteFavouriteItem(favaouriteItem: FavavouriteItem)
}