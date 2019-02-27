package com.garuca.testscreengo.profile.ui

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.garuca.testscreengo.R
import com.garuca.testscreengo.profile.model.Panel
import kotlinx.android.synthetic.main.item_panel.view.*

class PanelsAdapter(private val panels : List<Panel>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_panel_2,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return panels.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val panel: Panel = panels[position]
            Glide.with(context).load(panel.screenshots[0].image.url)
                .centerCrop()
                .into(holder.image_left)

        if (panel.screenshots.size>1) {
            Glide.with(context).load(panel.screenshots[1].image.url)
                .centerCrop()
                .into(holder.image_center)

        }else{
            Glide.with(context).clear(holder.image_center)
            holder.image_center.setImageDrawable(null)
        }
        if (panel.screenshots.size>2) {
            Glide.with(context).load(panel.screenshots[2].image.url)
                .centerCrop()
                .into(holder.image_right)

        }else{
            Glide.with(context).clear(holder.image_right)
            holder.image_right.setImageDrawable(null)
        }
        holder.title.text = panel.title
        if (panel.screenshots.size>1) {
            holder.number_prints.text = panel.screenshots.size.toString() + " prints"
        } else {
            holder.number_prints.text = panel.screenshots.size.toString() + " print"
        }

    }



}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val  number_prints = view.textView3
    val  title = view.textView2
    val image_left = view.image_left
    val image_right = view.image_right
    val image_center = view.image_center
}