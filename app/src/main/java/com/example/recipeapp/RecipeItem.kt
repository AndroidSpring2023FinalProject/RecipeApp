package com.example.recipeapp

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@kotlinx.serialization.Serializable
data class BaseResponse(
    @SerialName("api base response name")
    val docs: List<RecipeItem>?
)

@Keep
@Serializable
data class RecipeItem(
    @SerialName("some name")
    val apireference: String?

)