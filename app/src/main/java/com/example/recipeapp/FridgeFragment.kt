package com.example.recipeapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class FridgeFragment : Fragment(), OnFridgeItemClickListener {
    //private val ingredients = mutableListOf<Ingredient>()
    private lateinit var rvIngredients: RecyclerView
    private lateinit var tvFridgeLabel: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvIngredients = view.findViewById(R.id.rvFridgeIngredients)
        val btnDeleteFridge = view.findViewById<ImageButton>(R.id.iBtnDeleteAll)
        //val test = view.findViewById<Button>(R.id.testButton)
        tvFridgeLabel = view.findViewById<TextView>(R.id.label)
        rvIngredients.adapter = FridgeAdapter(requireContext(), FridgeIngredients.ingredients, this)
        rvIngredients.layoutManager = LinearLayoutManager(requireContext())

        rvIngredients.addItemDecoration(
            DividerItemDecoration(
                rvIngredients.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        btnDeleteFridge.setOnClickListener{
            val deleteMsg = Toast.makeText(requireContext(), "Deleting fridge...", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(IO) {
                (requireActivity().application as IngredientApplication).db.fridgeDao().deleteAll()
            }
            FridgeIngredients.deleteAllIngredients()
            rvIngredients.adapter?.notifyDataSetChanged()
        }
//        test.setOnClickListener{
//            val apple = Ingredient(1, "apple", "5")
//            val banana = Ingredient(2, "banana", "3")
//            val pear = Ingredient(3, "pear", "1")
//            FridgeIngredients.addIngredient(apple)
//            FridgeIngredients.addIngredient(banana)
//            FridgeIngredients.addIngredient(pear)
//            Log.d("Test Test button", FridgeIngredients.ingredients.toString())
//            lifecycleScope.launch(Dispatchers.IO){
//                (requireActivity().application as IngredientApplication).db.fridgeDao().insertAll(FridgeIngredients.ingredients)
//            }
//            //fetchGroceryList()
//            rvIngredients.adapter?.notifyDataSetChanged()
//        }

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
            (requireActivity().application  as IngredientApplication).db.fridgeDao().delete(ingredient)
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
                    FridgeIngredients.deleteAllIngredients()
                    FridgeIngredients.addIngredients(mappedList as ArrayList<Ingredient>)
                    rvIngredients.adapter?.notifyDataSetChanged()
                    if(FridgeIngredients.ingredients.size < 1){
                        tvFridgeLabel.setText("Fridge is empty")
                    }else{
                        tvFridgeLabel.setText("Fridge")
                    }
                }
            }
        }
    }

    override fun onItemClick(ingredient: Ingredient) {
        var toast = Toast.makeText(this.requireContext(), "Deleting " + ingredient.name, Toast.LENGTH_SHORT).show()
        FridgeIngredients.decrementIngredient(ingredient)
        if(FridgeIngredients.ingredients.contains(ingredient)){
            lifecycleScope.launch(IO) {
                (requireActivity().application as IngredientApplication).db.fridgeDao().updateIngredient(ingredient)
            }
        }else{
            deleteIngredient(ingredient)
        }
        rvIngredients.adapter?.notifyDataSetChanged()
    }


}