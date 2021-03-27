package com.example.workshopapp

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
        binding = ActivityMainBinding.inflate(layoutInflater)
        newsAdapter= NewsAdapter(listOf())
        initRv()
        shimmerFrameLayout= ShimmerFrameLayout(applicationContext)
        mainViewModel=
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MainViewModel::class.java)
        mainViewModel.fetchNewsData(Constants.apiKey,Constants.q).observe(this,{
            shimmerFrameLayout.stopShimmerAnimation()
            shimmerFrameLayout.visibility=View.GONE
            binding.recyclerView.visibility=View.VISIBLE
            newsAdapter.changeData(it.articles)
        })
        setContentView(binding.root)
    }

    private fun initRv() {
        binding.recyclerView.apply {
            adapter=newsAdapter
        }
    }
}