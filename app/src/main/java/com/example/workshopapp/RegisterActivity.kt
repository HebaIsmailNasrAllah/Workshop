package com.example.workshopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.databinding.ActivityRegisterBinding
import com.example.workshopapp.localData.viewModel.RegisterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var binding:ActivityRegisterBinding
    private lateinit var registerViewModel : RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_register)
         binding =ActivityRegisterBinding .inflate(layoutInflater)
               setContentView(binding.root)
        registerViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(RegisterViewModel::class.java)

        binding.buttonSignUp.setOnClickListener {
            registerViewModel.validateUser(binding.editUserName.text.toString(),binding.editPasswordSignUp.text.toString())

            var intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
}