package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea

@Database(entities = [EntityArea::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao
}