package com.garuca.testscreengo.profile

import com.garuca.testscreengo.profile.model.Panel
import com.garuca.testscreengo.profile.model.User

class ProfileContracts {
    interface PresenterInput{
        fun loadData()
    }

    interface PresenterOutput{
        fun setUser(user: User)
        fun setPanels(panels:List<Panel>)
    }

    interface InterectorInput{
       fun getAllProfileInformation()
    }

    interface InterectorOutput{
       fun setAllProfileInformation(user:User)

    }
}