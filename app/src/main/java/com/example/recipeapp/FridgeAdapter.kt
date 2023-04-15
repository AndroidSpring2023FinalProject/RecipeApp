package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlin.coroutines.coroutineContext

class FridgeAdapter(private val context: Context, private val ingredients: MutableList<Ingredient>): RecyclerView.Adapter<FridgeAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fridge_item, parent, false)
        return ItemViewHolder(view)
    }

    inner class ItemViewHolder(iView: View): RecyclerView.ViewHolder(iView), View.OnClickListener{
        var iIngredient: Ingredient? = null
        val iIngredientName: TextView = iView.findViewById<View>(R.id.tvIngredientItemName) as TextView
        val iIngredientQuantity: TextView = iView.findViewById<View>(R.id.tvIngredientItemQuantity) as TextView
        val iIngredientDelete: ImageButton = iView.findViewById(R.id.iBtnDelete) as ImageButton

        init{
            iIngredientDelete.setOnClickListener(this)
        }
        override fun onClick(v: View?){
            val ingredient = ingredients[adapterPosition]
            val toast = Toast.makeText(context, ingredient.name, Toast.LENGTH_SHORT)
            toast.show()
            ingredients.remove(ingredient)
            notifyItemRemoved(adapterPosition)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
        val ingredient = ingredients[position]
        holder.iIngredient = ingredient
        holder.iIngredientName.text = ingredient.name
        holder.iIngredientQuantity.text = ingredient.quantity
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

}