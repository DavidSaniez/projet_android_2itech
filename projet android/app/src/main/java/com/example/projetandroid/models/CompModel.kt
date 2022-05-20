package com.example.projetandroids.models

import java.util.*

class CompModel (
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    private var _niveau: Int = 0,
    var tags: MutableList<TagModel> = mutableListOf(),
    var description: String = "",
    var lastModification: String = ""
){
    var niveau:Int
      get() = _niveau
      set(newNiveau) {
          if(newNiveau < 0) _niveau = 0
          else if(newNiveau >20) _niveau = 20
          else _niveau = newNiveau
      }
}