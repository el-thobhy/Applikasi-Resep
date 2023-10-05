package com.elthobhy.applikasiresep.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseListPopular(

	@field:SerializedName("meals")
	val meals: List<MealsItemPopular>
)

data class MealsItemPopular(

	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null
)
