package com.example.spacetapp.Home.solarmap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModel
import com.example.spacetapp.Home.solarmap.repo.solarMapRepo

class SolarMapViewModelFactory(val solarMapRepo: solarMapRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(solarMapViewModel::class.java)) {
            solarMapViewModel(solarMapRepo) as T
        }else{
            throw IllegalArgumentException("SignUpViewModel class not found")
        }
    }
}