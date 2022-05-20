package com.example.projetandroids.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroids.MainActivity
import com.example.projetandroids.adapter.CompAdapter
import com.example.projetandroids.R
import com.example.projetandroids.repositories.CompetenceRepository

class HomeFragment(val context: MainActivity) : Fragment() {

    private val repo = CompetenceRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view)

        val compList = repo.competences

        recycler.adapter = CompAdapter(compList,context)

        return view
    }
}