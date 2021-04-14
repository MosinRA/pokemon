package com.mosin.mvp_kotlin.mvp.model.repo

import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import io.reactivex.rxjava3.core.Single

interface ICacheAllPokemon {
    fun putTo(pokemon: List<AllPokemon>)
    fun getFrom() : Single<List<AllPokemon>>
}