package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

data class SourcesItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val SourceDescription: String? = null,

	@field:SerializedName("language")
    var language: String? = null,

	@field:SerializedName("id")
	val sourceId: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("url")
	val sourceUrl: String? = null
)