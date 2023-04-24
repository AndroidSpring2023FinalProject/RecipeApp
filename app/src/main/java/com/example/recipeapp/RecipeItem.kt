package com.example.recipeapp

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class BaseResponse(
    @SerialName("recipes")
    val docs: List<RecipeItem>?
)

@Keep
@Serializable
data class RecipeItem(
    @SerialName("title")
    val recipetitle: String?,

    @SerialName("image")
    val imagepath: String,

    @SerialName("instructions")
    val instructions: String,

    @SerialName("readyInMinutes")
    val timetocook: String,

    ) : java.io.Serializable{
        val imagerec= imagepath
    }


