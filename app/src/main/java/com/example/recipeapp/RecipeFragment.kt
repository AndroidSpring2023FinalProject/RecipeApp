package com.example.recipeapp

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.google.android.material.tabs.TabLayout.TabGravity
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}


/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment() {
    private lateinit var reciperecyclerview: RecyclerView

    private val recipeslist= mutableListOf<RecipeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)
        reciperecyclerview = view.findViewById<RecyclerView>(R.id.recipeslist)
        reciperecyclerview.layoutManager = LinearLayoutManager(context)
        reciperecyclerview.adapter = RecipeAdapter(requireContext(), recipeslist)
        updateAdapter(reciperecyclerview)
        return view
    }


    private fun updateAdapter(recyclerView: RecyclerView){
        //progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()

        params["apiKey"]="d0ae067c7b234078840996184bc99937"
        params["number"]="10"

        client.get("https://api.spoonacular.com/recipes/random", params, object : JsonHttpResponseHandler(){

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "failed to fetch recies: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                Log.i(TAG, "successfuly fetched recipes: $json")
                try{
                    val parsedJson=createJson().decodeFromString(
                        BaseResponse.serializer(),
                        json?.jsonObject.toString()
                    )
                    parsedJson.docs?.let{ list->
                        recipeslist.addAll(list)
                        reciperecyclerview.adapter?.notifyDataSetChanged()
                    }
                } catch(e: JSONException){
                    Log.e(TAG, "Exception in parsing: $e")
                }
            }
        })
    }

    //----------------------------------------------------------
    companion object {

        fun newInstance(): RecipeFragment{
            return RecipeFragment()
        }
    }
}