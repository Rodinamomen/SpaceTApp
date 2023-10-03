package com.example.spacetapp.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val userName :String,
    val userEmail:String,
    var userScore:Int = 0,
    val userPassword:String
)