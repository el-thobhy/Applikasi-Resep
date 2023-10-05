package com.elthobhy.applikasiresep.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ResponseListArea(

	@field:SerializedName("meals")
	val meals: List<MealsItem>
)

data class MealsItem(

	@field:SerializedName("strArea")
	val strArea: String
)
