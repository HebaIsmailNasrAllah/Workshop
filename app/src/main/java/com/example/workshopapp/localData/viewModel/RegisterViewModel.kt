package com.example.workshopapp.localData.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.workshopapp.localData.UserEntity
import com.example.workshopapp.localData.viewModel.Dao.LocalDataSource

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    var localDataSource:LocalDataSource
    init {
        localDataSource= LocalDataSource(application)
    }
    fun validateUser(userName : String,email :String,password :String){
        if(!userName.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty() ){
            var user = UserEntity(userName,email,password)
        }else{
            Log.i("register","enter valid data")
        }
    }
   suspend fun insertUser(userentity :UserEntity){
        return localDataSource.insertUser(userentity)
    }



}