package com.example.spacetapp.Authentiaction.SignUp.Repo

import com.example.spacetapp.dataBase.User
import com.example.spacetapp.localDataBase.localDataBase

class signUpRepoImp(val localDataBase: localDataBase) : signUpRepo {
    override suspend fun insertUser(user: User) {
        localDataBase.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        localDataBase.deleteUser(user)
    }

    override suspend fun isUserExist(email: String, password: String): Boolean {
     return  localDataBase.isUserExist(email, password)
    }

    override suspend fun isEmailExist(email: String): Boolean {
        return localDataBase.isEmailExist(email)
    }
}