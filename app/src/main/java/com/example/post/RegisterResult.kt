package com.example.post

import com.google.gson.annotations.SerializedName

data class RegisterResult (

    @SerializedName("token") val token :String,
    @SerializedName("createdAt") val createdAt :String
        )
