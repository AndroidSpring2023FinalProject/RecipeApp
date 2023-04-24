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


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private lateinit var reciperecyclerview: RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeFragment : Fragment() {
    private val recipeslist= mutableListOf<RecipeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        reciperecyclerview=findViewById(R.id.recipeslist)
        val therecipeadapter= context?.let { RecipeAdapter(it, recipeslist) }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }


    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView){
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"]="d0ae067c7b234078840996184bc99937"

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
                        therecipeadapter.notifyDataSetChanged()
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