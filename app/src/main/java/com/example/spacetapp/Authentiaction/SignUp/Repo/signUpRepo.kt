package com.example.spacetapp.Authentiaction.SignUp.Repo

import com.example.spacetapp.dataBase.User

interface signUpRepo {
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun isUserExist(email: String, password: String ) : Boolean
    suspend fun isEmailExist(email: String):Boolean
}