package com.example.spacetapp.localDataBase

import com.example.spacetapp.dataBase.User

interface localDataBase {
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
}