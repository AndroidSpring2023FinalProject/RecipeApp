package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryAdapter(private val context: Context, private val ingredients: MutableList<IngredientGrocery>, var listener: OnGroceryItemClickListener): RecyclerView.Adapter<GroceryAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_item, parent, false)
        return ItemViewHolder(view)
    }

    inner class ItemViewHolder(iView: View): RecyclerView.ViewHolder(iView){
        var iIngredient: IngredientGrocery? = null
        val iIngredientName: TextView = iView.findViewById<View>(R.id.tvIngredientGroceryItemName) as TextView
        val iIngredientQuantity: TextView = iView.findViewById<View>(R.id.tvIngredientGroceryItemQuantity) as TextView
        val iIngredientDelete: ImageButton = iView.findViewById(R.id.iBtnGroceryItemDelete) as ImageButton
        val iIngredientCheck: ImageButton = iView.findViewById(R.id.iBtnGroceryItemCheck) as ImageButton

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        val ingredient = ingredients[position]
        holder.iIngredient = ingredient
        holder.iIngredientName.text = ingredient.name
        holder.iIngredientQuantity.text = ingredient.quantity
        holder.iIngredientDelete.setOnClickListener{
            holder.iIngredient.let { ingredient ->
                if (ingredient != null) {
                    listener?.onItemClickDelete(ingredient)
                }
            }
        }
        holder.iIngredientCheck.setOnClickListener{
            holder.iIngredient.let { ingredient ->
                if (ingredient != null) {
                    listener?.onItemClickCheck(ingredient)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

}