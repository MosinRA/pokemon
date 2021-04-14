package com.mosin.mvp_kotlin.di

import com.mosin.mvp_kotlin.di.modules.*
import com.mosin.mvp_kotlin.mvp.presenter.MainPresenter
import com.mosin.mvp_kotlin.mvp.presenter.InfoForPokemonPresenter
import com.mosin.mvp_kotlin.mvp.presenter.AllPokemonPresenter
import com.mosin.mvp_kotlin.ui.activity.MainActivity
import com.mosin.mvp_kotlin.ui.adapter.StartPokemonAdapter
import com.mosin.mvp_kotlin.ui.fragment.InfoForPokemonFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CiceroneModule::class,
        RepoModule::class,
        CacheModule::class,
        ImageModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(allPokemonPresenter: AllPokemonPresenter)
    fun inject(infoForPokemonPresenter: InfoForPokemonPresenter)
    fun inject(infoForPokemonFragment: InfoForPokemonFragment)
    fun inject(startPokemonAdapter: StartPokemonAdapter)
}