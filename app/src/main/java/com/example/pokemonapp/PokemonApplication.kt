package com.example.pokemonapp

import android.app.Application
import com.example.pokemonapp.network.services.PokemonService
import com.example.pokemonapp.repositories.PokemonRepository

class PokemonApplication:Application() {
    private val pokemonService by lazy {
        PokemonService()
    }
    val pokemonRepository by lazy {
        PokemonRepository(pokemonService)
    }
}