package com.example.workshopapp.localData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity")
data class UserEntity (
//    var userName:String,
    var email :String,
    var password :String

)
    {
        @PrimaryKey(autoGenerate = true) var id:Int=0
    }

