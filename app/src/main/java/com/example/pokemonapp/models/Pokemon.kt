package com.example.pokemonapp.models

import com.google.gson.annotations.SerializedName

/*
Pokemon data
 */

data class Pokemon(
    /*
    Official name of pokemon
     */
    var name: String,
    /*
    Url to front image view of pokemon
     */
    @SerializedName("url") var image: String
)
