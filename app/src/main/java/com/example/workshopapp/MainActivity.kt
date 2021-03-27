package com.example.workshopapp

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.adapters.NewsAdapter
import com.example.workshopapp.api.Constants
import com.example.workshopapp.databinding.ActivityMainBinding
import androidx.lifecycle.observe
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var shimmerFrameLayout: ShimmerFrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //binding = ActivityMainBinding.inflate(layoutInflater)


        shimmerFrameLayout= ShimmerFrameLayout(applicationContext)
        mainViewModel=
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MainViewModel::class.java)
        mainViewModel.fetchNewsData(Constants.apiKey,Constants.q)
        newsAdapter= NewsAdapter(listOf(),mainViewModel,this)
        initRv()
        mainViewModel.liveData.observe(this,{
            shimmerFrameLayout.stopShimmerAnimation()
            shimmerFrameLayout.visibility=View.GONE
            binding.recyclerView.visibility=View.VISIBLE
            newsAdapter.changeData(it)
        })
        binding.goToFavourite.setOnClickListener {
            val intent=Intent(this,FavouriteActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }

    private fun initRv() {
        binding.recyclerView.apply {
            adapter=newsAdapter
        }
    }
}