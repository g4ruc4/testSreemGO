package com.garuca.testscreengo.profile.model

import com.google.gson.annotations.SerializedName


class User(
    val email: String,
    val image: Image,
    val name: String,
    val screenshots: Screenshots
)
class Screenshots(
    val qtde : Int,
    @SerializedName("images")
    val screenshots:Array<Screenshot>
)


