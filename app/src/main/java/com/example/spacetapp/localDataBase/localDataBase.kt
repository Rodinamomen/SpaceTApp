package com.example.spacetapp.localDataBase

import com.example.spacetapp.dataBase.User

interface localDataBase {
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)

    suspend fun isUserExist(email: String, password: String ): Boolean

    suspend fun isEmailExist(email: String): Boolean
    suspend fun getUserScore(userEmail: String): Int
}