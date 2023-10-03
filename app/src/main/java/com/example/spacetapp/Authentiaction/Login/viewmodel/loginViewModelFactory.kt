package com.example.spacetapp.Authentiaction.Login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacetapp.Authentiaction.Login.repo.loginRepo
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModel

class loginViewModelFactory(val loginRepo: loginRepo): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(loginViewModel::class.java)) {
            loginViewModel(loginRepo) as T
        }else{
            throw IllegalArgumentException("SignUpViewModel class not found")
        }
    }
}