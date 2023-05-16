package com.example.pokemonapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapp.R
import com.example.pokemonapp.models.Pokemon

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var listPokemon: List<Pokemon>? = null

    fun setPokemons(list: List<Pokemon>) {
        listPokemon = list
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //enlaca el itemView con la lista pokemon

        val imagePokemon: ImageView = itemView.findViewById(R.id.pokemonImage)
        val namePokemon: TextView = itemView.findViewById(R.id.pokemonName)

        fun bind(pokemon: Pokemon) {
            namePokemon.text = pokemon.name
            Glide
                .with(itemView)
                .load(pokemon.image)
                .into(imagePokemon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pokemon, parent, false)

        //TODO()
        return PokemonViewHolder(view)
    }

    override fun getItemCount():Int = listPokemon?.size?: 0

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        listPokemon?.let {
            holder.bind(it[position])
        }
    }
}