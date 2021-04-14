package com.mosin.mvp_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.model.repo.IAllPokemonRepo
import com.mosin.mvp_kotlin.mvp.navigation.IScreens
import com.mosin.mvp_kotlin.mvp.presenter.list.IAllPokemonListPresenter
import com.mosin.mvp_kotlin.mvp.view.StartAllPokemonView
import com.mosin.mvp_kotlin.mvp.view.list.IUserItemView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class AllPokemonPresenter() : MvpPresenter<StartAllPokemonView>() {

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var pokemonRepo: IAllPokemonRepo

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler


    class UsersListPresenter : IAllPokemonListPresenter {

        val pokemonList = mutableListOf<AllPokemon>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val pokemon = pokemonList[view.pos]
            view.setLogin(pokemon.name.english)
            pokemon.hires.let { view.loadAvatar(it) }
        }

        override fun getCount() = pokemonList.size
    }

    val usersListPresenter = UsersListPresenter()
    val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { view ->
            val pokemon = usersListPresenter.pokemonList[view.pos]
            router.navigateTo(screens.pokemon(pokemon))
        }
    }

    fun loadData() {
        val disposable = pokemonRepo.getPokemon()
            .observeOn(uiScheduler)
            .subscribe({ pokeminList ->
                usersListPresenter.pokemonList.addAll(pokeminList)
                viewState.updateList()
            }, { error ->
                println("Error: ${error.message}")
            })
        compositeDisposable.add(disposable)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}