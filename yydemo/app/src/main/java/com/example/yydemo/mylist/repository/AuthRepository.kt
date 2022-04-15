package com.example.yydemo.mylist.repository

import com.example.yydemo.mylist.service.LoginAPI


class AuthRepository(
    private val api: LoginAPI

) : BaseRepository(){

    suspend fun login(
        username: String,
        password: String
    ) = safeApiCall {
        api.login(username,password)
    }
}