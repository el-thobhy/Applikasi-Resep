package com.elthobhy.applikasiresep.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_popular")
data class EntityPopular(
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "idMeal")
    val idMeal: String,

    @ColumnInfo(name = "strMeal")
    val strMeal: String? = null
)
