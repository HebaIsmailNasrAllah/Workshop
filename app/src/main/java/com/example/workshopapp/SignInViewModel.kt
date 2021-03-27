package com.example.workshopapp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel(){

    fun validate_login(user:String, password: String, context: Context) {
        //fun db
        if(user.isNullOrEmpty() || password.isNullOrEmpty()){
            Toast.makeText(context, "User name and password can't be Empty", Toast.LENGTH_SHORT).show()
        }else{
            
        }


    }

}