package com.elthobhy.applikasiresep.core.data.source.local

import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityPopular
import com.elthobhy.applikasiresep.core.data.source.local.room.Dao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: Dao) {
    fun getArea(): Flow<List<EntityArea>> = dao.getArea()
    fun getPopular(): Flow<List<EntityPopular>> = dao.getPopular()
    fun getDetail(id: String): Flow<List<EntityDetail>> = dao.getDetail(id)

    suspend fun insertDetail(entityDetail: List<EntityDetail>) = dao.insertDetail(entityDetail)
    suspend fun insertPopular(entityPopular: List<EntityPopular>) = dao.insertPopular(entityPopular)
    suspend fun insert(entityArea: List<EntityArea>) = dao.insert(entityArea)
}