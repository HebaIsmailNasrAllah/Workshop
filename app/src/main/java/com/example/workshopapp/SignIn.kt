package com.example.workshopapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workshopapp.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    lateinit var userName: String
    lateinit var passwor: String
    lateinit var signInViewModel: SignInViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signInViewModel = SignInViewModel()

        binding.btnSignIn.setOnClickListener{
            signInViewModel.validate_login(binding.etSigninUsername.text.toString(), binding.etSigninPassword.text.toString(), this )
        }





    }


}