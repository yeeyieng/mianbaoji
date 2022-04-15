package com.example.yydemo.mylist.repository

import com.example.yydemo.mylist.service.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException


abstract class BaseRepository {

    // Suspend function can only be called from a coroutine or another suspend function
    // Function used to start, pause and resume together with coroutines
    // Coroutines = cooperation with other functions, A work - A pause - B work - B pause - back to A work
    suspend fun <T> safeApiCall(
        apiCall: suspend() -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO){
            try{
                Resource.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                     Resource.Failure(false,throwable.code(),throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true,null,null)
                    }
                }
            }
        }
    }
}