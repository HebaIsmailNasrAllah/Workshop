package com.example.workshopapp.signin

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.workshopapp.MainActivity
import com.example.workshopapp.Utils

class SignInViewModel : ViewModel() {

    fun validate_login(userEmail: String, password: String, context: Context) {

        if (!userEmail.isNullOrEmpty() || !password.isNullOrEmpty()) {
            if (!Utils.validateRegistration(userEmail, password)) {
                if(userEmail.equals("")){
                   // context.startActivity(Intent(t))
                }else{
                    Toast.makeText(context, "User doesn't exist", Toast.LENGTH_SHORT).show() }
            }else{
                Toast.makeText(context, "Ivalid User name or password, Please try again", Toast.LENGTH_SHORT).show() }
        }else{
            Toast.makeText(context, "User name and password can't be Empty", Toast.LENGTH_SHORT).show() }


    }

}