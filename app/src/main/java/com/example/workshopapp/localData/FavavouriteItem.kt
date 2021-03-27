package com.example.workshopapp.localData

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.model.SourcesItem
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_list")
data class FavavouriteItem(

    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @field:SerializedName("description")
    val description: String? = null,
    @Embedded
    @field:SerializedName("source")
    val source: SourcesItem? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("content")
    val content: String? = null
){
    @PrimaryKey(autoGenerate = true)
    var id=0
}