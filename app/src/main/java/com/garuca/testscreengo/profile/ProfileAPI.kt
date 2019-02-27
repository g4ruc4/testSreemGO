package com.garuca.testscreengo.profile
import com.garuca.testscreengo.profile.model.Profile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileAPI {
    @GET("tests/list")
    fun get( @Query("id")id:Int): Call<Profile>
}

