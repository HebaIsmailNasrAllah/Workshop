package com.example.workshopapp.signin

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.workshopapp.Utils

class SignInViewModel : ViewModel() {

    fun validate_login(userEmail: String, password: String, context: Context) {

        if (!userEmail.isNullOrEmpty() || !password.isNullOrEmpty()) {
            if (!Utils.validateRegistration(userEmail, password)) {
                if(userEmail.equals("")){
                    //if(){} exists in db navigate
                }else{ }

            }else{
                Toast.makeText(context, "Ivalid User name or password, Please try again", Toast.LENGTH_SHORT).show() }
        }else{
            Toast.makeText(context, "User name and password can't be Empty", Toast.LENGTH_SHORT).show() }


    }

}