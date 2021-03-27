package com.example.workshopapp.localData.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.workshopapp.localData.UserEntity
import com.example.workshopapp.localData.viewModel.Dao.LocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    var localDataSource:LocalDataSource
    init {
        localDataSource= LocalDataSource(application)
    }
  fun validateUser(email :String,password :String){
      Log.i("useremail",email)
      Log.i("userPass",password)
        if( !email.isNullOrEmpty() && !password.isNullOrEmpty() ){
            var user = UserEntity(email,password)
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("validate","validateee")
            insertUser(user)
               if( getUserByEmail(user.email) !=null){
                   Log.i("validate","getUserByEmail")
               }
            }

        }else{
            Log.i("register","enter valid data")
        }
    }
  private suspend fun insertUser(userentity :UserEntity){
         localDataSource.insertUser(userentity)
      Log.i("validate","validateee2")
    }
    suspend fun getUserByEmail(email:String):UserEntity{
        return localDataSource.getUserByEmail(email)
    }



}