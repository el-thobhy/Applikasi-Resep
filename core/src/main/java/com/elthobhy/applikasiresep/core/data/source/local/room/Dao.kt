package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM list_area")
    fun getArea(): Flow<List<EntityArea>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entityArea: List<EntityArea>)

}