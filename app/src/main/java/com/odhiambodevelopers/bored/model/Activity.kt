package com.odhiambodevelopers.bored.model


import com.google.gson.annotations.SerializedName

data class Activity(
    val activity: String,
    val participants: Int,
    val price: Double,
    val type: String
)