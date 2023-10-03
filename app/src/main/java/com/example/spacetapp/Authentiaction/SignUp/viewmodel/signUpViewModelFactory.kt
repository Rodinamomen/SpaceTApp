package com.example.spacetapp.Authentiaction.SignUp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacetapp.Authentiaction.SignUp.Repo.signUpRepo

class signUpViewModelFactory(val signUpRepo:signUpRepo):  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(signUpViewModel::class.java)) {
           signUpViewModel(signUpRepo) as T
        }else{
            throw IllegalArgumentException("SignUpViewModel class not found")
        }
    }
}