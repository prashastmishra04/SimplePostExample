package com.example.post

import com.google.gson.annotations.SerializedName

 data class Register (

    @SerializedName("email") val email:String,
    @SerializedName("password" ) val password:String
        )