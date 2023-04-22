package com.example.recipeapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GroceryDao {

    @Query("SELECT * FROM grocery_table")
    fun getAll(): Flow<List<IngredientGrocery>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(ingredients: List<IngredientGrocery>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ingredient: IngredientGrocery)

    @Update
    fun updateIngredient(ingredient: IngredientGrocery)

    @Update
    fun updateAllIngredients(ingredient: List<IngredientGrocery>)

    @Query("DELETE FROM grocery_table")
    fun deleteAll()

    @Delete
    fun delete(ingredient: IngredientGrocery)
}