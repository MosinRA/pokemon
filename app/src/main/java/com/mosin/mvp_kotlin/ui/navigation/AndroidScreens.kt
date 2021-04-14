package com.mosin.mvp_kotlin.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.navigation.IScreens
import com.mosin.mvp_kotlin.ui.fragment.InfoForPokemonFragment
import com.mosin.mvp_kotlin.ui.fragment.AllPokemonFragment

class AndroidScreens : IScreens {
    override fun allPokemon() = FragmentScreen { AllPokemonFragment.newInstance() }

    override fun pokemon(pokemon: AllPokemon) =
        FragmentScreen { InfoForPokemonFragment.newInstance(pokemon) }
}