package com.example.workshopapp.localData
import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workshopapp.localData.viewModel.Dao.UserDao

@Database(entities =[ UserEntity::class] ,version = 1)
abstract class ApiObjDataBase : RoomDatabase() {
    // abstract fun apiObjDao(): NewsResponseDao
    abstract fun userObjDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ApiObjDataBase? = null

        fun getDatabase(application: Application): ApiObjDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        application.applicationContext,
                        ApiObjDataBase::class.java,
                        "NewsDB"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}