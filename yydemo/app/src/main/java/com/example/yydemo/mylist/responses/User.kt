package com.example.yydemo.mylist.responses

data class User(
    val userID: String,
    val entityID: String,
    val username: String,
    val userGroupID: String,
    val userGroupName: String,
    val token: String,
    val userTypeID: String,
    val userTypeName: String
)
