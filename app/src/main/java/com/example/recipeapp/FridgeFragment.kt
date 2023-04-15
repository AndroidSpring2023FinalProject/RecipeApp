package com.example.recipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class FridgeFragment : Fragment() {
    private val ingredients = mutableListOf<Ingredient>()
    private lateinit var rvIngredients: RecyclerView
    private lateinit var tvFridgeLabel: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvIngredients = view.findViewById(R.id.rvFridgeIngredients)
        val btnDeleteFridge = view.findViewById<ImageButton>(R.id.iBtnDeleteAll)
        val test = view.findViewById<Button>(R.id.testButton)
        tvFridgeLabel = view.findViewById<TextView>(R.id.label)
        rvIngredients.adapter = FridgeAdapter(requireContext(), ingredients)
        rvIngredients.layoutManager = LinearLayoutManager(requireContext())

        btnDeleteFridge.setOnClickListener{
            val deleteMsg = Toast.makeText(requireContext(), "Deleting fridge...", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(IO) {
                (requireActivity().application as IngredientApplication).db.fridgeDao().deleteAll()
            }
            ingredients.clear()
            rvIngredients.adapter?.notifyDataSetChanged()
        }
        test.setOnClickListener{
            val apple = Ingredient(1, "apple", "5")
            val banana = Ingredient(2, "banana", "1")
            val pear = Ingredient(3, "pear", "1")
            ingredients.add(apple)
            ingredients.add(banana)
            ingredients.add(pear)
            lifecycleScope.launch(IO){
                (requireActivity().application as IngredientApplication).db.fridgeDao().insertAll(ingredients)
            }
            rvIngredients.adapter?.notifyDataSetChanged()
        }
        fetchFridge()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fridge, container, false)
    }

    companion object {
        fun newInstance(): FridgeFragment{
            return FridgeFragment()
        }
    }

    fun deleteIngredient(ingredient: Ingredient){
        lifecycleScope.launch(IO) {
            (MainActivity() as IngredientApplication).db.fridgeDao().delete(ingredient)
        }
    }

//    fun deleteItem(position: Int){
//        rvIngredients.adapter.deleteItem(position)
//    }

    fun fetchFridge(){
        lifecycleScope.launch{
            (requireActivity().application as IngredientApplication).db.fridgeDao().getAll().collect(){ databaseList ->
                databaseList.map { ingredient ->
                    Ingredient(
                        ingredient.id,
                        ingredient.name,
                        ingredient.quantity
                    )
                }.also { mappedList ->
                    ingredients.clear()
                    ingredients.addAll(mappedList)
                    rvIngredients.adapter?.notifyDataSetChanged()
                    if(ingredients.size == 0){
                        tvFridgeLabel.setText("Fridge is empty")
                    }else{
                        tvFridgeLabel.setText("Fridge")
                    }
                }
            }
        }
    }


}