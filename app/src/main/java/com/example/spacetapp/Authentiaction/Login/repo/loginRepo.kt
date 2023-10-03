package com.example.spacetapp.Authentiaction.Login.repo

interface loginRepo {
    suspend fun isUserExist(email: String, password: String ) : Boolean
    suspend fun isEmailExist(email: String):Boolean
}