package com.example.gauseva.Api

import com.example.gauseva.Models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {

//Register Data
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("register")
    fun register(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("phone") phone: String
    ): Call<LoginResponse>


//Login
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("login")
    fun login(
        @Field("email") email: String
    ): Call<LoginResponse>


}