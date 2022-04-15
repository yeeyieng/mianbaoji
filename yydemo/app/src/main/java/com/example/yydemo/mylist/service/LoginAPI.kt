package com.example.yydemo.mylist.service

import com.example.yydemo.mylist.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// To define API Calls

interface LoginAPI{

    @FormUrlEncoded
    @POST("Authentication/login") //Define URL Endpoint

    suspend fun login( // Suspend because using coroutines for asynchronous calls
        @Field("username")username: String,
        @Field("password")password: String
    ) : LoginResponse // Return type as LoginResponse
}