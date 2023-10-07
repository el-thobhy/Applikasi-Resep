package com.elthobhy.applikasiresep.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_category_meal")
data class EntityCategoryMeal (
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "idMeal")
    val idMeal: String,

    @ColumnInfo(name = "strMeal")
    val strMeal: String? = null,

    @ColumnInfo(name= "isBeef")
    var isBeef: Boolean = false,

    @ColumnInfo(name= "isBreakfast")
    var isBreakfast: Boolean = false,

    @ColumnInfo(name= "isChicken")
    var isChicken: Boolean = false,

    @ColumnInfo(name= "isDessert")
    var isDessert: Boolean = false,

    @ColumnInfo(name= "isGoat")
    var isGoat: Boolean = false,

    @ColumnInfo(name= "isLamb")
    var isLamb: Boolean = false,

    @ColumnInfo(name= "isMiscellaneous")
    var isMiscellaneous: Boolean = false,

    @ColumnInfo(name= "isPasta")
    var isPasta: Boolean = false,

    @ColumnInfo(name= "isPork")
    var isPork: Boolean = false,

    @ColumnInfo(name= "isSeafood")
    var isSeafood: Boolean = false,

    @ColumnInfo(name= "isSide")
    var isSide: Boolean = false,

    @ColumnInfo(name= "isStarter")
    var isStarter: Boolean = false,

    @ColumnInfo(name= "isVegan")
    var isVegan: Boolean = false,

    @ColumnInfo(name= "isVegetarian")
    var isVegetarian: Boolean = false,
)