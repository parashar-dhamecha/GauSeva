package com.example.gauseva.Api

import android.util.Base64
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASEURL = "https://gaushala-admin.codebrik.com/api/auth/"
    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttp = OkHttpClient.Builder().addInterceptor(loggingInterceptor)

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()
         retrofit.create(Api::class.java)
    }
}