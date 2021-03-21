package com.mosin.mvp_kotlin.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class GitHubRepo(
    @Expose val name: String,
) : Parcelable