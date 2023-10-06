package com.elthobhy.applikasiresep.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.elthobhy.applikasiresep.core.data.source.local.entity.Entity
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategoryMeal
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM tabel_category_meal")
    fun getListCategory(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_popular")
    fun getPopular(): Flow<List<EntityMain>>

    @Query("SELECT * FROM tabel_category")
    fun getCategory(): Flow<List<EntityCategory>>

    @Query("SELECT * FROM detail_tabel WHERE idMeal = :id ")
    fun getDetail(id: String): Flow<List<EntityDetail>>

    @Query("SELECT * FROM table_search WHERE strMeal LIKE '%' || :name || '%'")
    fun getSearch(name: String): Flow<List<EntitySearch>>

    @Query("SELECT * FROM list")
    fun getArea(): Flow<List<Entity>>



    @Query("SELECT * FROM tabel_category_meal WHERE isStarter = 1")
    fun getStarter(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isBeef = 1")
    fun getBeef(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isBreakfast = 1")
    fun getBreakfast(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isChicken = 1")
    fun getChicken(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isDessert = 1")
    fun getDessert(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isGoat = 1")
    fun getGoat(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isLamb = 1")
    fun getLamb(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isMiscellaneous = 1")
    fun getMiscellaneous(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isPasta = 1")
    fun getPasta(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isPork = 1")
    fun getPork(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isSeafood = 1")
    fun getSeafood(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isSide = 1")
    fun getSide(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isVegan = 1")
    fun getVegan(): Flow<List<EntityCategoryMeal>>

    @Query("SELECT * FROM tabel_category_meal WHERE isVegetarian = 1")
    fun getVegetarian(): Flow<List<EntityCategoryMeal>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(entityCategory: List<EntityCategory>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(entitySearch: List<EntitySearch>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(entityArea: List<EntityMain>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: List<EntityCategoryMeal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(entityDetail: List<EntityDetail>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArea(entity: List<Entity>)


    @Update
    fun updateStatusStarter(data: List<EntityCategoryMeal>)


}