package com.mosin.mvp_kotlin.mvp.model.entity.api

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize


@Parcelize
data class Profile(
    @Expose val height: String,
    @Expose val weight: String
) : Parcelable
