package com.elthobhy.applikasiresep.core.data.source.local

import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.room.Dao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: Dao) {
    fun getArea(): Flow<List<EntityArea>> = dao.getArea()
    suspend fun insert(entityArea: List<EntityArea>) = dao.insert(entityArea)
}