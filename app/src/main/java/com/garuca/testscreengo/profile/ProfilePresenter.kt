package com.garuca.testscreengo.profile

import com.garuca.testscreengo.profile.model.Panel
import com.garuca.testscreengo.profile.model.Screenshot
import com.garuca.testscreengo.profile.model.User


class ProfilePresenter(private val registerPresenterOutput: ProfileContracts.PresenterOutput):ProfileContracts.PresenterInput,ProfileContracts.InterectorOutput{
     override fun setAllProfileInformation(user: User) {
          registerPresenterOutput.setPanels(splitPanels(user.screenshots.screenshots))
          registerPresenterOutput.setUser(user=user)
     }

     var registerInterectorInput: ProfileContracts.InterectorInput = ProfileInterector(this)
     override fun loadData() {
          registerInterectorInput.getAllProfileInformation()
     }
     private fun splitPanels(screenshots:Array<Screenshot>):MutableList<Panel>{
          val panels : MutableList<Panel> = ArrayList()
          for (screenshot: Screenshot in screenshots){

               if (panels.contains(Panel(screenshot.panel_id,null))){
                    panels.forEachIndexed { index, panel ->
                         // ...
                         if (panel.id ==screenshot.panel_id){
                              panels[index].screenshots.add(screenshot)
                         }
                    }
               }else{
                    panels.add(Panel(screenshot.panel_id,"Pasta "+sum(panels.size)))
                    panels.forEachIndexed { index, panel ->
                         // ...
                         if (panel.id ==screenshot.panel_id){
                              panels[index].screenshots.add(screenshot)
                         }
                    }
               }
          }
          return panels
     }
     private fun sum(i:Int): Int {
          return i+1
     }

}