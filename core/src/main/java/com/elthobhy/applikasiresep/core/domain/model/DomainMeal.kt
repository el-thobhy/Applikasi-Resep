package com.elthobhy.applikasiresep.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainMeal(
    val strMealThumb: String? = null,
    val idMeal: String,
    val strMeal: String? = null,
    var isBeef: Boolean = false,
    var isBreakfast: Boolean = false,
    var isChicken: Boolean = false,
    var isDessert: Boolean = false,
    var isGoat: Boolean = false,
    var isLamb: Boolean = false,
    var isMiscellaneous: Boolean = false,
    var isPasta: Boolean = false,
    var isPork: Boolean = false,
    var isSeafood: Boolean = false,
    var isSide: Boolean = false,
    var isStarter: Boolean = false,
    var isVegan: Boolean = false,
    var isVegetarian: Boolean = false,
): Parcelable