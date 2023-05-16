package com.example.pokemonapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.pokemonapp.R
import com.example.pokemonapp.ui.list.PokemonListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PokemonListViewModel by viewModels{
        PokemonListViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this){
            if(it!= null){
                Log.d("Lista", it.toString())
            }
        }

        viewModel.getPokemons()
    }
}