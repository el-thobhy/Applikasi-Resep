package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch

@Database(entities = [EntityCategory::class,EntitySearch::class ,EntityArea::class, EntityMain::class, EntityDetail::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao
}