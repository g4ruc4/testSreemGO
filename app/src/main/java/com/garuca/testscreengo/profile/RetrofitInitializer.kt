package com.garuca.testscreengo.profile

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient



class RetrofitInitializer {
    private var httpClient = OkHttpClient.Builder()

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://api.screengo.com.br/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getProfileAPI(): ProfileAPI {
        return retrofit.create(ProfileAPI::class.java)
    }
}