package com.example.spacetapp.localDataBase

import com.example.spacetapp.dataBase.User
import com.example.spacetapp.dataBase.userDao

class localDataBaseImp: localDataBase {
    lateinit var userDao: userDao
    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
       userDao.deleteUser(user)
    }
}