package com.garuca.testscreengo.profile.model

class Panel(val id:Int,  val title:String?){

    val screenshots:MutableList<Screenshot> = ArrayList()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Panel

        if (id != other.id) return false

        return true
    }

}
