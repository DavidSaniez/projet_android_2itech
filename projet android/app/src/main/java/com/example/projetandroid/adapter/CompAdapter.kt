package com.example.projetandroids.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroids.R
import com.example.projetandroids.models.CompModel
import com.example.projetandroids.popups.CompetenceDetailPopup

class CompAdapter(
    val liste: List<CompModel>,
    val context: Context
) : RecyclerView.Adapter<CompAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val compNameView = view.findViewById<TextView>(R.id.comp_name)
        val compLvlView = view.findViewById<TextView>(R.id.comp_lvl)
        val tagView = view.findViewById<RecyclerView>(R.id.tags_recycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_competence, parent, false)

        val holder = ViewHolder(view)
       // holder.tagView.layoutManager = GridLayoutManager(parent.context,3)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comp = liste[position]
        holder.compNameView.text = comp.name
        val niveau = "niveau ${comp.niveau}"
        holder.compLvlView.text = niveau
        holder.tagView.adapter = TagAdapter(comp.tags)
        holder.itemView.setOnClickListener {
            CompetenceDetailPopup(context,comp).show()
        }

    }

    override fun getItemCount(): Int = liste.size
}