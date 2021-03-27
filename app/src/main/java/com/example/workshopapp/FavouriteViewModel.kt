package com.example.workshopapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.workshopapp.repo.NewsRepo
import java.lang.Appendable

class FavouriteViewModel(application: Application) : AndroidViewModel(application){
    lateinit var newsRepo: NewsRepo
    init {
        newsRepo= NewsRepo(application)
    }
    val liveData=newsRepo.getData()
}