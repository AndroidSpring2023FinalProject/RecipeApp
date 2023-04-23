package com.example.recipeapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FridgeDao {

    @Query("SELECT * FROM ingredients_table")
    fun getAll(): Flow<List<Ingredient>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(ingredients: List<Ingredient>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ingredient: Ingredient)

    @Update
    fun updateIngredient(ingredient: Ingredient)

    @Update
    fun updateAllIngredients(ingredient: List<Ingredient>)

    @Query("DELETE FROM ingredients_table")
    fun deleteAll()

    @Delete
    fun delete(ingredient: Ingredient)

}