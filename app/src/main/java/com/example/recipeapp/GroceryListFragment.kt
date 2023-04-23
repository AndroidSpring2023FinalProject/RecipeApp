package com.example.recipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceryListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private val GroceryListitem = mutableListOf<GroceryList>()
    private lateinit var groceryRv: RecyclerView
    private lateinit var groceryAdapter: GrocerylistsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_grocery_list, container, false)
        groceryRv = view.findViewById<RecyclerView>(R.id.groceryListItem)
        groceryAdapter = GrocerylistsAdapter(requireContext(),GroceryListitem)
        groceryRv.adapter = groceryAdapter

       groceryRv.layoutManager = LinearLayoutManager(requireContext()).also{
           val dividerItemDecoration = DividerItemDecoration(requireContext(),it.orientation)
           groceryRv.addItemDecoration(dividerItemDecoration)

       }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val add = activity?.findViewById(R.id.add) as ImageView

        lifecycleScope.launch(Dispatchers.IO) {

            add.setOnClickListener{


            }


        }
    }

    companion object {
        fun newInstance(): GroceryListFragment{
            return GroceryListFragment()
        }

    }
}