package com.elthobhy.applikasiresep.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainPopular(
    val strMealThumb: String? = null,
    val idMeal: String,
    val strMeal: String? = null
): Parcelable
