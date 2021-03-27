package com.example.workshopapp

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel(){

    fun validate_login(userEmail:String, password: String, context: Context) {
        //fun db
        if(userEmail.isNullOrEmpty() || password.isNullOrEmpty()){
            Toast.makeText(context, "User name and password can't be Empty", Toast.LENGTH_SHORT).show()
        }
        if(!Utils.validateRegistration(userEmail, password)){
            Toast.makeText(context, "Ivalid User name or password, Please try again", Toast.LENGTH_SHORT).show()
        }
        //if(){}


    }

}