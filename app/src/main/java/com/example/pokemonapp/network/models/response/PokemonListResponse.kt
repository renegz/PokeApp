package com.example.pokemonapp.network.models.response

import com.example.pokemonapp.models.Pokemon

/*
se colocan parametros de peticion
 */

data class PokemonListResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon> //No servia por que no habiamos escrito bien el val, habiamos puesto result
)
