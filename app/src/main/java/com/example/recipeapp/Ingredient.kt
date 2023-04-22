package com.example.recipeapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients_table")
class Ingredient(
    @PrimaryKey(autoGenerate = true) val id: Long =0,
    @ColumnInfo(name = "ingredientName") val name: String,
    @ColumnInfo(name = "ingredientQuantity") var quantity: String


){
    fun decrementQuantity(){
        this.quantity = (this.quantity.toInt() -1).toString();
    }

    override fun toString(): String{
        return this.id.toString() + this.name + this.quantity
    }
}