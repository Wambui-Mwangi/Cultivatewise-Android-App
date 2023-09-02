
package com.mwangi.cultivatewise.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mwangi.cultivatewise.model.CropsResponse
import com.mwangi.cultivatewise.repository.CropsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CropsViewModel : ViewModel() {
    private val serverUrl = "http://10.0.2.2:8000/plant/crops/"
    val cropsRepo = CropsRepository()
    val cropsLiveData = MutableLiveData<List<CropsResponse>>()
    val errLiveData = MutableLiveData<String>()

    fun fetchCrops() {
        viewModelScope.launch {
            val response = cropsRepo.getCrops()
            if (response.isSuccessful) {
                cropsLiveData.postValue(response.body()?: emptyList())
            } else {
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
