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

    @SerialName("extendedIngredients")
    val inneringred: ArrayList<IgList>?

    ) : java.io.Serializable{
        val imagerec=imagepath
    }


@Keep
@Serializable
data class IgList(
    @SerialName("extendedIngredients")
    val ingredients: List<Unit>?
) : java.io.Serializable


@Keep
@Serializable
data class Unit(
    @SerialName("name")
    val ingname: String
): java.io.Serializable

