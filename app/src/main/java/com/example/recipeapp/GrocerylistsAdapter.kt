package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class GrocerylistsAdapter(private val context: Context, private val groceries: List<GroceryList>):
    RecyclerView.Adapter<GrocerylistsAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameOfList: TextView
        val ViewList: Button
        init {

            nameOfList = itemView.findViewById(R.id.nameOfList)
            ViewList = itemView.findViewById(R.id.button)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.grocerylists_items, parent, false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return groceries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grocerylist = groceries.get(position)
        holder.nameOfList.text = grocerylist.grocerylistName
    }
}