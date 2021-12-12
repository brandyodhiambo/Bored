package com.odhiambodevelopers.bored.data.network

import com.odhiambodevelopers.bored.model.Activity
import com.odhiambodevelopers.bored.util.Constants.ENDPOINT
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT)
    suspend fun getActivity(): Activity
}