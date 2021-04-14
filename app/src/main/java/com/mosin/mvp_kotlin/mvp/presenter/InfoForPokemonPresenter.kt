package com.mosin.mvp_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.view.PokeInfoView
import moxy.MvpPresenter
import javax.inject.Inject

class InfoForPokemonPresenter(
    val pokemon: AllPokemon
) :
    MvpPresenter<PokeInfoView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setLogin(pokemon.name.english)
        pokemon.hires.let { viewState.setImage(it) }
        viewState.setInfoForPokemon(
            pokemon.base.HP,
            pokemon.base.Attack,
            pokemon.base.Defense,
            pokemon.base.Speed,
            pokemon.profile.height,
            pokemon.profile.weight,
            pokemon.description
        )

    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}