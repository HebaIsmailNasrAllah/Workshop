package com.example.workshopapp.localData.viewModel.Dao

import android.app.Application
import com.example.workshopapp.localData.ApiObjDataBase
import com.example.workshopapp.localData.UserEntity

class LocalDataSource {
 lateinit var userDao:UserDao
   constructor (application: Application) {

     userDao  = ApiObjDataBase.getDatabase(application).userObjDao()
   }

      suspend fun insertUser(userEntity: UserEntity) {
          return userDao.insertUser(userEntity)
       }

}