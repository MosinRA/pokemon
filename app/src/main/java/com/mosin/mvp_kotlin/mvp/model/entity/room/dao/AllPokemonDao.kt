package com.mosin.mvp_kotlin.mvp.model.entity.room.dao

import androidx.room.*
import com.mosin.mvp_kotlin.mvp.model.entity.room.RoomAllPokemon

@Dao
interface AllPokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomAllPokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomAllPokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<RoomAllPokemon>)

    @Update
    fun update(user: RoomAllPokemon)

    @Update
    fun update(vararg users: RoomAllPokemon)

    @Update
    fun update(user: List<RoomAllPokemon>)

    @Delete
    fun delete(user: RoomAllPokemon)

    @Delete
    fun delete(vararg users: RoomAllPokemon)

    @Delete
    fun delete(user: List<RoomAllPokemon>)

    @Query("SELECT * FROM RoomAllPokemon")
    fun getAll(): List<RoomAllPokemon>

    @Query("SELECT * FROM RoomAllPokemon WHERE id = :login LIMIT 1 ")
    fun findByLogin(login: Int): RoomAllPokemon
}