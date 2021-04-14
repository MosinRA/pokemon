package com.mosin.mvp_kotlin.mvp.model.repo

import com.mosin.mvp_kotlin.mvp.model.api.IDataSource
import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import com.mosin.mvp_kotlin.mvp.model.network.INetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitAllPokemonRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: ICacheAllPokemon
) : IAllPokemonRepo {
    override fun getPokemon(): Single<List<AllPokemon>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline)
                api.getUsers().doAfterSuccess { pokemon ->
                    cache.putTo(pokemon)
                }
            else cache.getFrom()
        }.subscribeOn(Schedulers.io())
}