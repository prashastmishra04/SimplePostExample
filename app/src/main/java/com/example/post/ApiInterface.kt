package com.example.post

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    //it's not a good way to do post url method insted we directly put the body of pojo
//    @POST("register")
//    fun Registrer(@Query("email")email:String, @Query("password")password:String):Call<RegisterResult>

    @POST("register")
    fun registerUser(@Body register: Register):Call<RegisterResult>
}