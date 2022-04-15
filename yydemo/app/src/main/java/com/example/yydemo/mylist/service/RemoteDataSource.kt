package com.example.yydemo.mylist.service

import com.example.yydemo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Class to get the retrofit client
class RemoteDataSource {
    companion object{ // Define Base URL
        private const val BASE_URL = "https://www.google.com/"
    }

    fun<Api> buildApi( // Function that creates retrofit client and define fun type as API
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL.trim())
            .client(
                OkHttpClient.Builder().also{ client ->
                    if(BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
            }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}