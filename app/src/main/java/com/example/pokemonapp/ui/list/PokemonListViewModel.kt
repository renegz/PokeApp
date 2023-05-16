package com.example.pokemonapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokemonapp.PokemonApplication
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.repositories.PokemonRepository
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {
    val pokemons = MutableLiveData(listOf<Pokemon>())

    fun getPokemons() {
        viewModelScope.launch {
            val response = pokemonRepository.getPokemons(10, 0)
            pokemons.value = response.results
        }
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PokemonApplication
                PokemonListViewModel(app.pokemonRepository)
            }
        }
    }
}