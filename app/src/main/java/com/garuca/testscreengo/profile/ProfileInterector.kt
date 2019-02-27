package com.garuca.testscreengo.profile

import android.util.Log
import com.garuca.testscreengo.profile.ProfileContracts
import com.garuca.testscreengo.profile.model.Profile
import com.garuca.testscreengo.profile.ui.PanelsAdapter
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileInterector(private val interectorOutput: ProfileContracts.InterectorOutput):ProfileContracts.InterectorInput {
    override fun getAllProfileInformation() {
        val profileAPI: ProfileAPI = RetrofitInitializer()
            .getProfileAPI()
        val call: Call<Profile> =profileAPI.get(23)
        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                val code = response.code()
                val profile = response.body()
                when (code) {
                    200 -> {
                        Log.e("User",profile?.user?.screenshots!!.screenshots[0].name)
                        interectorOutput.setAllProfileInformation(profile.user)




                    }
                }
            }
            override fun onFailure(call: Call<Profile>, t: Throwable) {

            }


        })
    }


}