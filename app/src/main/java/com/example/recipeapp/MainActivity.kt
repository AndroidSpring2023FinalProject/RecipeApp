package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fridgeFragment: Fragment = FridgeFragment()
        val groceryListFragment: Fragment = GroceryListFragment()
        val recipesFragment: Fragment = RecipesListFragment()

        val btmNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        btmNavView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when(item.itemId){
                R.id.action_fridge -> fragment = fridgeFragment
                R.id.action_grocery_list -> fragment = groceryListFragment
                R.id.action_recipes -> fragment = recipesFragment
            }
            replaceFragment(fragment)
            true
        }

        btmNavView.selectedItemId = R.id.action_fridge;
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}