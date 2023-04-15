package com.example.recipeapp

import android.app.Application

class IngredientApplication : Application(){
    val db by lazy {AppDatabase.getInstance(this)}

}