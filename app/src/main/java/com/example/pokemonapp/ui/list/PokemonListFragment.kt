package com.example.pokemonapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonListBinding

class PokemonListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    private val viewModel: PokemonListViewModel by viewModels {
        PokemonListViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = binding.listPokemonRecycler
        viewModel.getPokemons()
        val adapter = PokemonAdapter()

        viewModel.pokemons.observe(viewLifecycleOwner){
            adapter.setPokemons(it)
        }

        rv.adapter = adapter
    }
}