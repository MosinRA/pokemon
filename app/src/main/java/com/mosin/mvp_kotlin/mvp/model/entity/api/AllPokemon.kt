package com.mosin.mvp_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class AllPokemon(
    @Expose val id: Int,
    @Expose val name: Name,
    @Expose val hires: String,
    @Expose val base: Base,
    @Expose val profile: Profile,
    @Expose val description: String
) : Parcelable