package com.example.spacetapp.localDataBase

import android.content.Context
import com.example.spacetapp.dataBase.User
import com.example.spacetapp.dataBase.userDao
import com.example.spacetapp.dataBase.userDataBase

class localDataBaseImp(context:Context): localDataBase {
    lateinit var UserDao: userDao
    init {
        val db: userDataBase = userDataBase.getInstance(context)
        UserDao= db.userDao()
    }
    override suspend fun insertUser(user: User) {
        UserDao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        UserDao.deleteUser(user)
    }

    override suspend fun isUserExist(email: String, password: String): Boolean {
        return UserDao.isUserExist(email, password)
    }

    override suspend fun isEmailExist(email: String): Boolean {
       return  UserDao.isEmailExist(email)
    }
}