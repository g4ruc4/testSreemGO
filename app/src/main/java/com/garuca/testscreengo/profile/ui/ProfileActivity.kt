package com.garuca.testscreengo.profile.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.garuca.testscreengo.R
import com.garuca.testscreengo.profile.*
import com.garuca.testscreengo.profile.model.Panel
import com.garuca.testscreengo.profile.model.User

import kotlinx.android.synthetic.main.activity_profile.*






class ProfileActivity : AppCompatActivity(),ProfileContracts.PresenterOutput{


    lateinit var presenterInput: ProfileContracts.PresenterInput
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        presenterInput = ProfilePresenter(this)
        presenterInput.loadData()


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setUser(user: User) {
        text_view_name.text = user.name
        Glide.with(this).load(user.image.url)
            .centerCrop()
            .into(profile_image)
            .onLoadFailed(this@ProfileActivity.getDrawable(R.drawable.iron))

    }
    override fun setPanels(panels: List<Panel>) {
        runOnUiThread {
            val manager = LinearLayoutManager(this@ProfileActivity)
            recycler_view.layoutManager = manager as RecyclerView.LayoutManager?
            val adapter  = PanelsAdapter(panels,this@ProfileActivity)
            recycler_view.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

}
