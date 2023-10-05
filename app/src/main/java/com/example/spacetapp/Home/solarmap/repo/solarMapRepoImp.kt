package com.example.spacetapp.Home.solarmap.repo

import com.example.spacetapp.localDataBase.localDataBase

class solarMapRepoImp(val localDataBase: localDataBase) : solarMapRepo{
    override suspend fun getUserScore(userEmail: String) :Int {
        return localDataBase.getUserScore(userEmail)
    }

    override suspend fun updateUserScore(userEmail: String, userScore: Int) {
        return localDataBase.updateUserScore(userEmail,userScore)
    }
}