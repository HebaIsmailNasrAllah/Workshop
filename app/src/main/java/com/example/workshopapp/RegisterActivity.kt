package com.example.workshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.databinding.ActivityRegisterBinding
import com.example.workshopapp.localData.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    private lateinit var registerViewModel : RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_register)
         binding =ActivityRegisterBinding .inflate(layoutInflater)
               setContentView(binding.root)
        registerViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(RegisterViewModel::class.java)
        registerViewModel.validateUser(binding.)
    }
}