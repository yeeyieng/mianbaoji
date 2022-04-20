package com.example.yydemo.mylist.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yydemo.mylist.service.Resource
import kotlinx.coroutines.launch
import com.example.yydemo.mylist.repository.AuthRepository
import com.example.yydemo.mylist.responses.LoginResponse

class AuthViewModel(
    private val repository: AuthRepository
):ViewModel(){

    // Store the loginResponse MutableLiveData as LiveData
    // Declare _loginResponse as MutableLiveData to put the loginResponse value
    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()

    // Store login response as live data, live data cannot be changed directly
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        username: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(username,password)
    }

}