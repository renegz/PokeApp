package com.example.pokemonapp.network.services

import com.example.pokemonapp.network.models.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    // Una restful
}