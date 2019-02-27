package com.garuca.testscreengo.profile.model

class Image(
    val big: Big,
    val medium: Medium,
    val thumb: Thumb,
    val url: String
)
class Thumb(
    val url: String
)

class Big(
    val url: String
)

class Medium(
    val url: String
)