package com.garuca.testscreengo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.garuca.testscreengo.profile.*
import com.garuca.testscreengo.profile.model.Panel
import com.garuca.testscreengo.profile.model.Profile
import com.garuca.testscreengo.profile.model.Screenshot
import com.garuca.testscreengo.profile.ui.PanelsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val profileAPI: ProfileAPI = RetrofitInitializer()
            .getProfileAPI()
        val call: Call<Profile> =profileAPI.get(23)
        call.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                val code = response.code()
                val profile = response.body()
                when (code) {
                    200 -> {




                    }
                }
            }
            override fun onFailure(call: Call<Profile>, t: Throwable) {

            }


        })
    }

}
