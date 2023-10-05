package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityPopular
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM list_area")
    fun getArea(): Flow<List<EntityArea>>

    @Query("SELECT * FROM tabel_popular")
    fun getPopular(): Flow<List<EntityPopular>>

    @Query("SELECT * FROM detail_tabel WHERE idMeal = :id ")
    fun getDetail(id: String): Flow<List<EntityDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopular(entityArea: List<EntityPopular>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entityArea: List<EntityArea>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(entityDetail: List<EntityDetail>)

}