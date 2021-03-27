package com.example.workshopapp.localData.viewModel.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workshopapp.localData.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_entity where email = :email")
    suspend fun getUserByEmail( email :String):UserEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user : UserEntity)


}