package com.mosin.mvp_kotlin.di.modules

import com.mosin.mvp_kotlin.mvp.model.api.IDataSource
import com.mosin.mvp_kotlin.mvp.model.network.INetworkStatus
import com.mosin.mvp_kotlin.mvp.model.repo.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: ICacheAllPokemon
    ): IAllPokemonRepo = RetrofitAllPokemonRepo(api, networkStatus, cache)
}
