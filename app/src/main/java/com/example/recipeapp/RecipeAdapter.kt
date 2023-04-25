package com.example.recipeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

const val RECIPE_EXTRA= "RECIPE_EXTRA"
class RecipeAdapter(private val context: Context, private val recipeslist: List<RecipeItem>):
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recipe_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.ViewHolder, position: Int) {
        val recipes =recipeslist[position]
        holder.bind(recipes)
    }

    override fun getItemCount() = recipeslist.size

    //pass to details page
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {
        private val imageview = itemView.findViewById<ImageView>(R.id.recipeimage)
        private val titleview = itemView.findViewById<TextView>(R.id.recipetitle)
        private val cooktime = itemView.findViewById<TextView>(R.id.cooktime)
        private val ingredients=itemView.findViewById<TextView>(R.id.ingredients)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(recipeItem: RecipeItem) {
            titleview.text = recipeItem.recipetitle
            cooktime.text="Cook Time: "+recipeItem.timetocook
            //ingredients.text= recipeItem.inneringred.toString()


            Glide.with(context)
                .load(recipeItem.imagerec)
                .into(imageview)
        }

        override fun onClick(p0: View?) {
            val recipe=recipeslist[absoluteAdapterPosition]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(RECIPE_EXTRA, recipe)
            context.startActivity(intent)
        }

    }

}