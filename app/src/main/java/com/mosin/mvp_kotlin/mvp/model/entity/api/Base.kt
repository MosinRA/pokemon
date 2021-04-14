package com.mosin.mvp_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Base(
    @Expose val HP: Int = 0,
    @Expose val Attack: Int = 0,
    @Expose val Defense: Int= 0,
    @Expose val Speed: Int
) : Parcelable
