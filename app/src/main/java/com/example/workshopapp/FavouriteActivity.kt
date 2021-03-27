package com.example.workshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.workshopapp.adapters.FavouriteAddapter
import com.example.workshopapp.databinding.ActivityFavouriteBinding
import com.example.workshopapp.databinding.ActivityMainBinding

class FavouriteActivity : AppCompatActivity() {
    lateinit var binding: ActivityFavouriteBinding
    lateinit var favouriteViewModel: FavouriteViewModel
    lateinit var favouriteAddapter: FavouriteAddapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteBinding.inflate(layoutInflater)
        favouriteAddapter= FavouriteAddapter(listOf())
        initRv()
        favouriteViewModel=
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(FavouriteViewModel::class.java)
        favouriteViewModel.liveData.observe(this,{
           favouriteAddapter.changeData(it)
        })
        setContentView(binding.root)
    }

    private fun initRv() {
        binding.recyclerView.apply {
            adapter=favouriteAddapter
        }
    }
}