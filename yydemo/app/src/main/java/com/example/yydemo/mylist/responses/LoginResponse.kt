package com.example.yydemo.mylist.responses

data class LoginResponse(
    val userId: String,
    val entityID: String,
    val username: String,
    val userGroupID: String,
    val userGroupName: String,
    val token: String,
    val userTypeID: String,
    val userTypeName: String
)
