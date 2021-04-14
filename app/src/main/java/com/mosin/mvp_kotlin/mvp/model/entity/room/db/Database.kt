package com.mosin.mvp_kotlin.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mosin.mvp_kotlin.mvp.model.entity.room.RoomCachedImage
import com.mosin.mvp_kotlin.mvp.model.entity.room.RoomAllPokemon
import com.mosin.mvp_kotlin.mvp.model.entity.room.dao.ImageDao
import com.mosin.mvp_kotlin.mvp.model.entity.room.dao.AllPokemonDao

@androidx.room.Database(
    entities = [
        RoomAllPokemon::class,
        RoomCachedImage::class
    ],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val allPokemonDao: AllPokemonDao
    abstract val imageDao: ImageDao

    companion object {
        const val DB_NAME = "pokeDb.db"
        private var instance: Database? = null
        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, Database::class.java, DB_NAME)
                    .build()
            }
        }

    }
}