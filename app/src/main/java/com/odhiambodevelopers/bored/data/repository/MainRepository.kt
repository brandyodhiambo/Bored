package com.odhiambodevelopers.bored.data.repository

import com.odhiambodevelopers.bored.data.network.ApiService
import com.odhiambodevelopers.bored.data.network.SafeApiCall
import com.odhiambodevelopers.bored.model.Activity
import com.odhiambodevelopers.bored.util.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService):SafeApiCall(){

    suspend fun getAnActivity() = safeApiCall {
        apiService.getActivity()
    }
}