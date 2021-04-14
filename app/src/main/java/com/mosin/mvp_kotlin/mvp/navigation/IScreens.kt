package com.mosin.mvp_kotlin.mvp.navigation

import com.github.terrakok.cicerone.Screen
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon

interface IScreens {
    fun allPokemon(): Screen
    fun pokemon(pokemon: AllPokemon): Screen
}