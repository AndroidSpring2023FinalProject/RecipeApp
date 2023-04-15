package com.example.recipeapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients_table")
class Ingredient(
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    @ColumnInfo(name = "ingredientName") val name: String,
    @ColumnInfo(name = "ingredientQuantity") val quantity: String
)