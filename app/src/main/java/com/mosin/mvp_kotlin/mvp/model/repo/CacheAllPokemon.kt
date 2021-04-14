package com.mosin.mvp_kotlin.mvp.model.repo

import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.model.entity.room.RoomAllPokemon
import com.mosin.mvp_kotlin.mvp.model.entity.room.db.Database
import io.reactivex.rxjava3.core.Single


class CacheAllPokemon(private val db: Database) : ICacheAllPokemon {
    override fun putTo(pokemon: List<AllPokemon>) {
        val roomPokemon = pokemon.map { pokemon ->
            RoomAllPokemon(
                pokemon.id,
                pokemon.name,
                pokemon.hires,
                pokemon.base,
                pokemon.profile,
                pokemon.description
            )
        }
        db.allPokemonDao.insert(roomPokemon)
    }

    override fun getFrom() = Single.fromCallable {
        db.allPokemonDao.getAll().map { roomPokemon ->
            AllPokemon(
                roomPokemon.id,
                roomPokemon.name,
                roomPokemon.avatarUrl,
                roomPokemon.base,
                roomPokemon.profile,
                roomPokemon.description
            )
        }
    }
}