package com.elthobhy.applikasiresep.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_area")
data class EntityArea(
    @PrimaryKey
    @ColumnInfo(name = "strArea")
    val strArea: String
)
