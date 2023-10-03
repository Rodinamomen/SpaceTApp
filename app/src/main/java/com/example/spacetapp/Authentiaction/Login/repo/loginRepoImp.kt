package com.example.spacetapp.Authentiaction.Login.repo

import com.example.spacetapp.localDataBase.localDataBase

class loginRepoImp(val localDataBase: localDataBase) : loginRepo {

    override suspend fun isUserExist(email: String, password: String): Boolean {
       return localDataBase.isUserExist(email, password)
    }

    override suspend fun isEmailExist(email: String): Boolean {
       return localDataBase.isEmailExist(email)
    }
}