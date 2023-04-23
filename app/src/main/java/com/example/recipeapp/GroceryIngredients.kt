package com.example.recipeapp

import android.util.Log
import java.util.ArrayList

/**
 * THIS IS DESIGNED FOR INGREDIENTS IN GROCERYLIST
 * GroceryIngredients is a single instance class that can be called anywhere
 * in the application and it will retain it's values. This class contains
 * an ArrayList ingredients referencing the ingredients in the GroceryList.
 * This class contains functions that will help manipulate the data
 * in the fridge.
 */
object GroceryIngredients {

    init{
        Log.d("Test", "Singleton class invoked")
    }
    var ingredients = ArrayList<IngredientGrocery>()

    /**
     * This function takes in IngredientGrocery as a parameter and increments
     * existing ingredients in the ArrayList by the parameter's .quatity value.
     * If the ingredient does not already exist, then the function will add
     * the quantity value of the parameter to the existing ingredient's quantity value.
     * @param ingredient object of type IngredientGrocery
     */
    fun addIngredient(ingredient: IngredientGrocery){
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

    /**
     * Not complete.
     */
    fun addIngredientWithQuantity(ingredient: IngredientGrocery, quantity: Int){
        if(this.ingredients.contains(ingredient)){
            var index = this.ingredients.indexOf(ingredient)
            (this.ingredients.get(index)).quantity = ((this.ingredients.get(index)).quantity.toInt() + quantity).toString()
        }else{
            this.ingredients.add(ingredient)
            this.ingredients.get(this.ingredients.size-1).quantity = quantity.toString()
        }
    }

    /**
     * Adds multiple ingredients. This solution calls forEach to add them individually
     * to this class's existing arrayList.
     * @param ingredients An arrayList of IngredientGrocery
     */
    fun addIngredients(ingredients: ArrayList<IngredientGrocery>){
        ingredients.forEach{
            addIngredient(it)
        }
    }

    /**
     * Deletes all the ingredients in the existing arrayList.
     */
    fun deleteAllIngredients(){
        this.ingredients.clear()
    }

    /**
     * Not complete.
     */
    fun getIngredientIndex(ingredient: IngredientGrocery): Int{
        if(this.ingredients.contains(ingredient)){
            return this.ingredients.indexOf(ingredient)
        }
        Log.d("Test", "Ingredient not found")
        return -1
    }

    /**
     * This method will take an IngredientGrocery as a parameter and decrement
     * the quantity value of the matching Ingredient by 1. This method
     * will check if the quantity reaches 0. If the check returns true,
     * then the IngredientGrocery will be removed from the arrayList.
     * @param ingredient Object of type Ingredient
     */
    fun decrementIngredient(ingredient: IngredientGrocery){
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

    /**
     * Increments this class's matching ingredient by the parameter's quantity
     * value if it exists.
     * @param ingredient Object of type IngredientGrocery
     * @param index Index of the target IngredientGrocery in the arraList.
     */
    fun incrementIngredient(ingredient: IngredientGrocery, index: Int){
        this.ingredients.get(index).quantity = (this.ingredients.get(index).quantity.toInt()+ingredient.quantity.toInt()).toString()
    }

    /**
     * This method checks if the method is empty and returns a boolean.
     * @return Determines true if the ingredient's quantity value reaches 0 or below.
     *          Otherwise, returns false.
     */
    private fun isQuantityEmpty(ingredient: IngredientGrocery) :Boolean{
        if(ingredient.quantity.toInt() < 1){
            Log.d("Test", "Quantity: " + ingredient.quantity.toInt())
            return true
        }
        return false;
    }
}