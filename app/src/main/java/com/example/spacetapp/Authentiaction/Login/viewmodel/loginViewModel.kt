package com.example.spacetapp.Authentiaction.Login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetapp.Authentiaction.Login.repo.loginRepo
import kotlinx.coroutines.launch

class loginViewModel(val loginRepo: loginRepo): ViewModel() {
    private val _isEmailExists= MutableLiveData<Boolean>()
    val isEmailExists= _isEmailExists
    private val _isUserWithEmailExists = MutableLiveData<Boolean>()
    val isUserWithEmailExists = _isUserWithEmailExists
    fun isEmailExists(email: String){
        viewModelScope.launch{
            val response= loginRepo.isEmailExist(email)
            _isEmailExists.value= response
        }
    }
    fun  isUserWithEmailExists(email:String , password:String){
        viewModelScope.launch{
            val response= loginRepo.isUserExist(email,password)
            _isUserWithEmailExists.value=response
        }
    }

}