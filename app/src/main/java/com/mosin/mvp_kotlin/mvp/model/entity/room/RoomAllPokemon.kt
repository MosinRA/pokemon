package com.mosin.mvp_kotlin.mvp.model.entity.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mosin.mvp_kotlin.mvp.model.entity.api.Base
import com.mosin.mvp_kotlin.mvp.model.entity.api.Name
import com.mosin.mvp_kotlin.mvp.model.entity.api.Profile

@Entity
class RoomAllPokemon(
    @PrimaryKey val id: Int,
    @Embedded val name: Name,
    val avatarUrl: String,
    @Embedded val base: Base,
    @Embedded val profile: Profile,
    val description: String
)

