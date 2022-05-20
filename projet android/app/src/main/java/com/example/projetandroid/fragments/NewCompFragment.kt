package com.example.projetandroids.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.projetandroids.MainActivity
import com.example.projetandroids.R
import com.example.projetandroids.models.CompModel
import com.example.projetandroids.models.TagModel
import com.example.projetandroids.repositories.CompetenceRepository

class NewCompetenceFragment(private val mainActivity: MainActivity) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater
            .inflate(R.layout.fragment_new_competence,container,false)

        val nameView = view.findViewById<EditText>(R.id.name_input)
        val tagsView = view.findViewById<EditText>(R.id.tag_input)
        val descriptionView = view.findViewById<EditText>(R.id.description_input)
        val buttonView = view.findViewById<Button>(R.id.button_submit)


        buttonView.setOnClickListener {
            val name = nameView.text.toString()
            val tags = tagsView.text.split(",").map{ it.trim().lowercase()}
            val description = descriptionView.text.toString()

            val CompModel = CompModel(name=name, description = description)
            for(tag in tags){
                CompModel.tags.add(TagModel(tag))
            }
            CompetenceRepository.insert(CompModel)
            mainActivity.loadFragment(HomeFragment(mainActivity),R.string.home_page_title)
        }


        return view
    }
}