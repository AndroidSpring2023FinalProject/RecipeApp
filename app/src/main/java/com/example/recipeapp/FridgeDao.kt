package com.example.recipeapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FridgeDao {

    @Query("SELECT * FROM ingredients_table")
    fun getAll(): Flow<List<Ingredient>>

    @Insert
    fun insertAll(ingredients: List<Ingredient>)

    @Insert
    fun insert(ingredient: Ingredient)

    @Query("DELETE FROM ingredients_table")
    fun deleteAll()

    @Delete
    fun delete(ingredient: Ingredient)

}