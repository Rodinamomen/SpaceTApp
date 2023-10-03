package com.example.spacetapp.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 0)
abstract class userDataBase: RoomDatabase() {
    abstract fun userDao() : userDao
    companion object{
        @Volatile
        private var INSTANCE: userDataBase?= null
        fun getInstance(context: Context): userDataBase {
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    userDataBase::class.java,
                    "userDataBase"
                )   .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}