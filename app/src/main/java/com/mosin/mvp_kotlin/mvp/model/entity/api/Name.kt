package com.mosin.mvp_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    @Expose val english: String,
    @Expose val japanese: String,
    @Expose val chinese: String,
    @Expose val french: String
) : Parcelable
