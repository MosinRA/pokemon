package com.mosin.mvp_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface PokeInfoView : MvpView {
    fun init()
    fun setLogin(text: String)
    fun setImage(url: String)


    @OneExecution
    fun setInfoForPokemon(
        hp: Int,
        attack: Int,
        defense: Int,
        speed: Int,
        height: String,
        weight: String,
        description: String
    )
}