package com.example.recipeapp

import android.util.Log
import java.util.*

object FridgeIngredients{
    init{
        Log.d("Test", "Singleton class invoked")
    }
    var ingredients = ArrayList<Ingredient>()
    fun addIngredient(ingredient: Ingredient){
        Log.d("contain", this.ingredients.toString())
        Log.d("adding", ingredient.toString())
        Log.d("size", this.ingredients.size.toString())
        var contains = false
        var curIndex = 0;
        this.ingredients.forEachIndexed{index, eachIngredient ->
            Log.d("Testing", eachIngredient.name)
            if(ingredient.name == eachIngredient.name){
                contains = true
                curIndex = index
            }
        }
        if(contains) {
            incrementIngredient(ingredient, curIndex)
        }else{
            Log.d("I dont", "no")
            this.ingredients.add(ingredient)
            this.ingredients.get(this.ingredients.size-1).quantity = ingredient.quantity
        }

    }
    fun addIngredientWithQuantity(ingredient: Ingredient, quantity: Int){
        if(this.ingredients.contains(ingredient)){
            var index = this.ingredients.indexOf(ingredient)
            (this.ingredients.get(index)).quantity = ((this.ingredients.get(index)).quantity.toInt() + quantity).toString()
        }else{
            this.ingredients.add(ingredient)
            this.ingredients.get(this.ingredients.size-1).quantity = quantity.toString()
        }
    }
    fun addIngredients(ingredients: ArrayList<Ingredient>){
        this.ingredients.addAll(ingredients)
    }
    fun deleteAllIngredients(){
        this.ingredients.clear()
    }
    fun getIngredientIndex(ingredient: Ingredient): Int{
        if(this.ingredients.contains(ingredient)){
            return this.ingredients.indexOf(ingredient)
        }
        Log.d("Test", "Ingredient not found")
        return -1
    }
    fun decrementIngredient(ingredient: Ingredient){
        if(this.ingredients.contains(ingredient)){
            var index = this.ingredients.indexOf(ingredient)
            this.ingredients.get(index).decrementQuantity()
            if(isQuantityEmpty(this.ingredients.get(index))){
                this.ingredients.removeAt(index)
            }

        }else{
            Log.d("Test", "Ingredient was not found.")
        }
    }
    fun incrementIngredient(ingredient: Ingredient, index: Int){
        this.ingredients.get(index).quantity = (this.ingredients.get(index).quantity.toInt()+ingredient.quantity.toInt()).toString()
    }

    private fun isQuantityEmpty(ingredient: Ingredient) :Boolean{
        if(ingredient.quantity.toInt() < 1){
            Log.d("Test", "Quantity: " + ingredient.quantity.toInt())
            return true
        }
        return false;
    }
}