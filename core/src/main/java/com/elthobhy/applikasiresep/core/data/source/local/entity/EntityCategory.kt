package com.elthobhy.applikasiresep.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_category")
data class EntityCategory(

    @ColumnInfo(name = "strCategory")
    val strCategory: String? = null,

    @ColumnInfo(name = "strCategoryDescription")
    val strCategoryDescription: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "idCategory")
    val idCategory: String,

    @ColumnInfo(name = "strCategoryThumb")
    val strCategoryThumb: String? = null
)
