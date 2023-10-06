package com.elthobhy.applikasiresep.core.data.source.local

import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch
import com.elthobhy.applikasiresep.core.data.source.local.room.Dao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: Dao) {
    fun getArea(): Flow<List<EntityArea>> = dao.getArea()
    fun getMain(): Flow<List<EntityMain>> = dao.getPopular()
    fun getCategory(): Flow<List<EntityCategory>> = dao.getCategory()
    fun getDetail(id: String): Flow<List<EntityDetail>> = dao.getDetail(id)
    fun getSearch(name: String): Flow<List<EntitySearch>> = dao.getSearch(name)

    suspend fun insertCategory(entityCategory: List<EntityCategory>) = dao.insertCategory(entityCategory)
    suspend fun insertSearch(entitySearch: List<EntitySearch>) = dao.insertSearch(entitySearch)
    suspend fun insertDetail(entityDetail: List<EntityDetail>) = dao.insertDetail(entityDetail)
    suspend fun insertMain(entityMain: List<EntityMain>) = dao.insertMain(entityMain)
    suspend fun insert(entityArea: List<EntityArea>) = dao.insert(entityArea)
}