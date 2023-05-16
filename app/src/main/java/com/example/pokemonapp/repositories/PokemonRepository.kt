package com.example.pokemonapp.repositories

import com.example.pokemonapp.network.services.PokemonService

class PokemonRepository(val pokemonService: PokemonService) {

    suspend fun getPokemons(limit: Int, offset: Int) =
        pokemonService.getPokemons(limit, offset)

}