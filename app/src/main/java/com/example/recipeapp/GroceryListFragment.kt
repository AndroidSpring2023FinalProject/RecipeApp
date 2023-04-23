package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GroceryListFragment : Fragment(), OnGroceryItemClickListener {
    private lateinit var rvIngredients: RecyclerView
    private lateinit var tvGroceryLabel: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvGroceryLabel = view.findViewById(R.id.labelGrocery)
        rvIngredients = view.findViewById(R.id.rvGroceryIngredients)
        rvIngredients.adapter = GroceryAdapter(requireContext(), GroceryIngredients.ingredients, this)
        rvIngredients.layoutManager = LinearLayoutManager(requireContext())
        val addIngButton = view.findViewById<Button>(R.id.btnAddIngredient)
        val test = view.findViewById<Button>(R.id.testButton)
        addIngButton.setOnClickListener{
            val intent = Intent(requireContext(), AddGroceryIngredient::class.java)
            requireContext().startActivity(intent)
        }
        test.setOnClickListener{
            val apple = IngredientGrocery(1, "apple", "5")
            val banana = IngredientGrocery(2, "banana", "3")
            val pear = IngredientGrocery(3, "pear", "1")
            GroceryIngredients.addIngredient(apple)
            GroceryIngredients.addIngredient(banana)
            GroceryIngredients.addIngredient(pear)
            Log.d("Test Test button", GroceryIngredients.ingredients.toString())
            lifecycleScope.launch(Dispatchers.IO){
                (requireActivity().application as IngredientApplication).db.groceryDao().insertAll(GroceryIngredients.ingredients)
            }
            rvIngredients.adapter?.notifyDataSetChanged()
        }
        fetchGroceryList()
        rvIngredients.adapter?.notifyDataSetChanged()
    }
    fun fetchGroceryList(){
        lifecycleScope.launch{
            (requireActivity().application as IngredientApplication).db.groceryDao().getAll().collect(){ databaseList ->
                databaseList.map { ingredient ->
                    Log.d("Database Ing", ingredient.toString())
                    IngredientGrocery(
                        ingredient.id,
                        ingredient.name,
                        ingredient.quantity
                    )
                }.also { mappedList ->
                    Log.d("Mapp", mappedList.toString())
                    GroceryIngredients.deleteAllIngredients()
                    GroceryIngredients.addIngredients(mappedList as ArrayList<IngredientGrocery>)
                    rvIngredients.adapter?.notifyDataSetChanged()
                    if(GroceryIngredients.ingredients.size < 1){
                        tvGroceryLabel.setText("List is empty")
                    }else{
                        tvGroceryLabel.setText("Grocery List")
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grocery_list, container, false)
    }

    companion object {
        fun newInstance(): GroceryListFragment{
            return GroceryListFragment()
        }
    }

    fun deleteIngredient(ingredient: IngredientGrocery){
        lifecycleScope.launch(Dispatchers.IO) {
            (requireActivity().application  as IngredientApplication).db.groceryDao().delete(ingredient)
        }
    }

    override fun onItemClickDelete(ingredient: IngredientGrocery) {
        var toast = Toast.makeText(this.requireContext(), "Deleting " + ingredient.name, Toast.LENGTH_SHORT).show()
        GroceryIngredients.decrementIngredient(ingredient)
        if(GroceryIngredients.ingredients.contains(ingredient)){
            lifecycleScope.launch(Dispatchers.IO) {
                (requireActivity().application as IngredientApplication).db.groceryDao().updateIngredient(ingredient)
            }
        }else{
            deleteIngredient(ingredient)
        }
        rvIngredients.adapter?.notifyDataSetChanged()
    }

    override fun onItemClickCheck(ingredient: IngredientGrocery) {
        var toast = Toast.makeText(this.requireContext(), "Adding " + ingredient.name + " to fridge", Toast.LENGTH_SHORT).show()
        val fridgeIngredient = Ingredient(ingredient.id, ingredient.name, "1")
        var curIndex = 0;

        FridgeIngredients.addIngredient(fridgeIngredient)
        FridgeIngredients.ingredients.forEachIndexed{index, eachIngredient ->
            Log.d("Testing", eachIngredient.name)
            if(ingredient.name == eachIngredient.name){
                curIndex = index
            }
        }
        GroceryIngredients.decrementIngredient(ingredient)

        if(GroceryIngredients.ingredients.contains(ingredient)){
            lifecycleScope.launch(Dispatchers.IO) {
                (requireActivity().application as IngredientApplication).db.groceryDao().updateIngredient(ingredient)
            }
            lifecycleScope.launch(Dispatchers.IO){
                (requireActivity().application as IngredientApplication).db.fridgeDao().insert(FridgeIngredients.ingredients.get(curIndex))
            }
        }else{
            deleteIngredient(ingredient)
        }
        rvIngredients.adapter?.notifyDataSetChanged()
    }
}