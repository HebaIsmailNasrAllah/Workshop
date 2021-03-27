package com.example.workshopapp.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.workshopapp.MainActivity
import com.example.workshopapp.databinding.ActivitySignInBinding


class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    lateinit var signInViewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signInViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(SignInViewModel::class.java)

        binding.btnSignIn.setOnClickListener{
            signInViewModel.validate_login(binding.etSigninUsername.text.toString(), binding.etSigninPassword.text.toString(), application).observe(this, Observer {
                if(it == 1){
                    startActivity(Intent(this, MainActivity::class.java))
                }else if(it == -1){
                    Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
                }else if(it == -2){
                    Toast.makeText(this, "Ivalid User name or password, Please try again", Toast.LENGTH_SHORT).show()
                }else if(it == -3){
                    Toast.makeText(this, "User name and password can't be Empty", Toast.LENGTH_SHORT).show()
                }
                Log.i("SignIn", "entered")
            })

        }


    }

}

