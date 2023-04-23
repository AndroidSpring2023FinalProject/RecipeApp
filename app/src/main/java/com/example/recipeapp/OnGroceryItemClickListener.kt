package com.example.recipeapp

interface OnGroceryItemClickListener {
    fun onItemClickDelete(ingredient: IngredientGrocery)
    fun onItemClickCheck(ingredient: IngredientGrocery)
}