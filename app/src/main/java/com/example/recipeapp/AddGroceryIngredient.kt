package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddGroceryIngredient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_grocery_ingredient)


        val autoIngredientsList = arrayOf("apple.1", "banana.2", "cherry.3", "date.4", "elderberry.5")
        var ingredientQuantity = findViewById<EditText>(R.id.etAddIngredientQuantity)
        var ingredient = findViewById<AutoCompleteTextView>(R.id.autoAddIngredient)
        ingredient.threshold = 1
        ingredient.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, autoIngredientsList))

        val submitButton = findViewById<Button>(R.id.btnAddSubmit)
        submitButton.setOnClickListener{
            if(autoIngredientsList.contains(ingredient.text.toString())){
                val ingredientSplitArray = ingredient.text.toString().split(".")
                val addIngredient = IngredientGrocery(ingredientSplitArray[1].toLong(), ingredientSplitArray[0], ingredientQuantity.text.toString())
                GroceryIngredients.addIngredient(addIngredient)
                var currIndex = 0;
                GroceryIngredients.ingredients.forEachIndexed{index, eachIngredient ->
                    Log.d("Testing", eachIngredient.name)
                    if(ingredientSplitArray[0] == eachIngredient.name){
                        currIndex = index
                    }
                }
                lifecycleScope.launch(Dispatchers.IO){
                    (application as IngredientApplication).db.groceryDao().insert(GroceryIngredients.ingredients.get(currIndex))
                }
                setResult(1)
                finish()
            }else{
                val notFound = Toast.makeText(this, "Ingredient not found", Toast.LENGTH_SHORT).show()
                ingredient.setText("")
                ingredientQuantity.setText("")

            }

        }

        ingredient.setOnItemClickListener { parent, view, position, id ->
            val selectedIngredient = parent.getItemAtPosition(position).toString()
            ingredient.setText(selectedIngredient)
        }

    }


}