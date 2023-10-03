package com.example.spacetapp.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface userDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("SELECT EXISTS(SELECT * FROM User WHERE userEmail = :email AND userPassword= :password)")
    suspend fun isUserExist(email: String, password: String ): Boolean
    @Query("SELECT EXISTS(SELECT * FROM User WHERE userEmail = :email )")
    suspend fun isEmailExist(email: String): Boolean
}