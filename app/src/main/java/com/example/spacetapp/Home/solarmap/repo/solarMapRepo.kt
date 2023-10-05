package com.example.spacetapp.Home.solarmap.repo

interface solarMapRepo {
    suspend fun getUserScore(userEmail: String) :Int
    suspend fun updateUserScore(userEmail: String, userScore:Int)
}