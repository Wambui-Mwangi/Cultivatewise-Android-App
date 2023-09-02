package com.mwangi.cultivatewise.api

import com.mwangi.cultivatewise.model.CropsRequest
import com.mwangi.cultivatewise.model.CropsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("/plant/crops")
    suspend fun getCrops(): Response<List<CropsResponse>>
}