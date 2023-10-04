package com.example.spacetapp.Home.solarmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetapp.Home.solarmap.repo.solarMapRepo
import kotlinx.coroutines.launch

class solarMapViewModel(val solarMapRepo: solarMapRepo): ViewModel() {
    private  val _userScore = MutableLiveData<Int>()
    val userScore : LiveData<Int> = _userScore
    fun getUserScore(userEmail: String){
        viewModelScope.launch {
            val response = solarMapRepo.getUserScore(userEmail)
            _userScore.value= response
        }
    }
}