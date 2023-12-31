package com.elthobhy.applikasiresep.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_tabel")
data class EntityDetail (
    @ColumnInfo(name = "strImageSource")
    val strImageSource: String? = null,

    @ColumnInfo(name = "strIngredient10")
    val strIngredient10: String? = null,

    @ColumnInfo(name = "strIngredient12")
    val strIngredient12: String? = null,

    @ColumnInfo(name = "strIngredient11")
    val strIngredient11: String? = null,

    @ColumnInfo(name = "strIngredient14")
    val strIngredient14: String? = null,

    @ColumnInfo(name = "strCategory")
    val strCategory: String? = null,

    @ColumnInfo(name = "strIngredient13")
    val strIngredient13: String? = null,

    @ColumnInfo(name = "strIngredient16")
    val strIngredient16: String? = null,

    @ColumnInfo(name = "strIngredient15")
    val strIngredient15: String? = null,

    @ColumnInfo(name = "strIngredient18")
    val strIngredient18: String? = null,

    @ColumnInfo(name = "strIngredient17")
    val strIngredient17: String? = null,

    @ColumnInfo(name = "strArea")
    val strArea: String? = null,

    @ColumnInfo(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = null,

    @ColumnInfo(name = "strIngredient19")
    val strIngredient19: String? = null,

    @ColumnInfo(name = "strTags")
    val strTags: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "idMeal")
    val idMeal: String,

    @ColumnInfo(name = "strInstructions")
    val strInstructions: String? = null,

    @ColumnInfo(name = "strIngredient1")
    val strIngredient1: String? = null,

    @ColumnInfo(name = "strIngredient3")
    val strIngredient3: String? = null,

    @ColumnInfo(name = "strIngredient2")
    val strIngredient2: String? = null,

    @ColumnInfo(name = "strIngredient20")
    val strIngredient20: String? = null,

    @ColumnInfo(name = "strIngredient5")
    val strIngredient5: String? = null,

    @ColumnInfo(name = "strIngredient4")
    val strIngredient4: String? = null,

    @ColumnInfo(name = "strIngredient7")
    val strIngredient7: String? = null,

    @ColumnInfo(name = "strIngredient6")
    val strIngredient6: String? = null,

    @ColumnInfo(name = "strIngredient9")
    val strIngredient9: String? = null,

    @ColumnInfo(name = "strIngredient8")
    val strIngredient8: String? = null,

    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String? = null,

    @ColumnInfo(name = "strMeasure20")
    val strMeasure20: String? = null,

    @ColumnInfo(name = "strYoutube")
    val strYoutube: String? = null,

    @ColumnInfo(name = "strMeal")
    val strMeal: String? = null,

    @ColumnInfo(name = "strMeasure12")
    val strMeasure12: String? = null,

    @ColumnInfo(name = "strMeasure13")
    val strMeasure13: String? = null,

    @ColumnInfo(name = "strMeasure10")
    val strMeasure10: String? = null,

    @ColumnInfo(name = "strMeasure11")
    val strMeasure11: String? = null,

    @ColumnInfo(name = "dateModified")
    val dateModified: String? = null,

    @ColumnInfo(name = "strDrinkAlternate")
    val strDrinkAlternate: String? = null,

    @ColumnInfo(name = "strSource")
    val strSource: String? = null,

    @ColumnInfo(name = "strMeasure9")
    val strMeasure9: String? = null,

    @ColumnInfo(name = "strMeasure7")
    val strMeasure7: String? = null,

    @ColumnInfo(name = "strMeasure8")
    val strMeasure8: String? = null,

    @ColumnInfo(name = "strMeasure5")
    val strMeasure5: String? = null,

    @ColumnInfo(name = "strMeasure6")
    val strMeasure6: String? = null,

    @ColumnInfo(name = "strMeasure3")
    val strMeasure3: String? = null,

    @ColumnInfo(name = "strMeasure4")
    val strMeasure4: String? = null,

    @ColumnInfo(name = "strMeasure1")
    val strMeasure1: String? = null,

    @ColumnInfo(name = "strMeasure18")
    val strMeasure18: String? = null,

    @ColumnInfo(name = "strMeasure2")
    val strMeasure2: String? = null,

    @ColumnInfo(name = "strMeasure19")
    val strMeasure19: String? = null,

    @ColumnInfo(name = "strMeasure16")
    val strMeasure16: String? = null,

    @ColumnInfo(name = "strMeasure17")
    val strMeasure17: String? = null,

    @ColumnInfo(name = "strMeasure14")
    val strMeasure14: String? = null,

    @ColumnInfo(name = "strMeasure15")
    val strMeasure15: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)