package com.mwangi.cultivatewise.repository

import com.mwangi.cultivatewise.api.ApiClient
import com.mwangi.cultivatewise.api.ApiInterface
import com.mwangi.cultivatewise.model.CropsRequest
import com.mwangi.cultivatewise.model.CropsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CropsRepository {
    private val cropsService = ApiClient.retrofit.create(ApiInterface::class.java)
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getCrops(): Response<List<CropsResponse>>{
        return withContext(Dispatchers.IO){
            apiClient.getCrops()
        }
    }
}