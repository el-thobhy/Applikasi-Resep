package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM list_area")
    fun getArea(): Flow<List<EntityArea>>

    @Query("SELECT * FROM tabel_popular")
    fun getPopular(): Flow<List<EntityMain>>

    @Query("SELECT * FROM tabel_category")
    fun getCategory(): Flow<List<EntityCategory>>

    @Query("SELECT * FROM detail_tabel WHERE idMeal = :id ")
    fun getDetail(id: String): Flow<List<EntityDetail>>

    @Query("SELECT * FROM table_search WHERE strMeal LIKE '%' || :name || '%'")
    fun getSearch(name: String): Flow<List<EntitySearch>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(entityCategory: List<EntityCategory>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(entitySearch: List<EntitySearch>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(entityArea: List<EntityMain>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entityArea: List<EntityArea>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(entityDetail: List<EntityDetail>)

}