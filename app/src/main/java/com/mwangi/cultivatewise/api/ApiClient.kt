package com.mwangi.cultivatewise.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        fun <T> buildClient(apiInterface: Class<T>): T {
            return retrofit.create(apiInterface)
        }
}
