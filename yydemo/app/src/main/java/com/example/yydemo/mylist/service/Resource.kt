package com.example.yydemo.mylist.service

import okhttp3.ResponseBody

// A sealed class to wrap up API responses, handle all kind of API responses towards
// actual result or error
sealed class Resource<out T> {

    // Response for success
    data class Success<out T>(val value: T): Resource<T>()

    // Response for Failure
    data class Failure(
        val isNetworkError: Boolean, // Ask if there is network error
        val errorCode: Int?, // Get the actual api error code in case no network error
        val errorBody: ResponseBody?
    ) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}