package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityPopular

@Database(entities = [EntityArea::class, EntityPopular::class, EntityDetail::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao
}