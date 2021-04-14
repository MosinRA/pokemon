package com.mosin.mvp_kotlin.mvp.model.api

import com.mosin.mvp_kotlin.mvp.model.entity.api.AllPokemon
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface  IDataSource {

    @GET("all")
    fun getUsers(): Single<List<AllPokemon>>
}