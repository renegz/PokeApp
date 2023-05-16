package com.example.pokemonapp.network.services

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonService {

    private val service: PokeApi = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())  //Convierte el json a los objetos definidos
        .build()
        .create(PokeApi::class.java)

    /*
    suspend es para correr en un hilo secundario
     */
    suspend fun getPokemons(limit: Int, offset: Int) = service.getPokemons(limit, offset)


    /* TAMBIEN SE PUEDE ASI PARA NO TENER QUE CREAR UNA INSTANCIA
    companion object{
        private val service: PokeApi = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .build()
            .create(PokeApi::class.java)

        fun getPokemons() = service.getPokemons()
    }*/
}