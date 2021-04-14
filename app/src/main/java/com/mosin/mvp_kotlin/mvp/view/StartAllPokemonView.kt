package com.mosin.mvp_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface StartAllPokemonView : MvpView {
    fun init()
    fun updateList()
}