package com.elthobhy.applikasiresep.core.data.source.local

import android.util.Log
import com.elthobhy.applikasiresep.core.data.source.local.entity.Entity
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategoryMeal
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch
import com.elthobhy.applikasiresep.core.data.source.local.room.Dao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dao: Dao) {
    fun getBeef(): Flow<List<EntityCategoryMeal>> = dao.getBeef()
    fun getBreakfast(): Flow<List<EntityCategoryMeal>> = dao.getBreakfast()
    fun getChicken(): Flow<List<EntityCategoryMeal>> = dao.getChicken()
    fun getDessert(): Flow<List<EntityCategoryMeal>> = dao.getDessert()
    fun getGoat(): Flow<List<EntityCategoryMeal>> = dao.getGoat()
    fun getLamb(): Flow<List<EntityCategoryMeal>> = dao.getLamb()
    fun getMiscellaneous(): Flow<List<EntityCategoryMeal>> = dao.getMiscellaneous()
    fun getPasta(): Flow<List<EntityCategoryMeal>> = dao.getPasta()
    fun getPork(): Flow<List<EntityCategoryMeal>> = dao.getPork()
    fun getSeafood(): Flow<List<EntityCategoryMeal>> = dao.getSeafood()
    fun getSide(): Flow<List<EntityCategoryMeal>> = dao.getSide()
    fun getStarter(): Flow<List<EntityCategoryMeal>> = dao.getStarter()
    fun getVegan(): Flow<List<EntityCategoryMeal>> = dao.getVegan()
    fun getVegetarian(): Flow<List<EntityCategoryMeal>> = dao.getVegetarian()


    fun getMain(): Flow<List<EntityMain>> = dao.getPopular()
    fun getCategory(): Flow<List<EntityCategory>> = dao.getCategory()
    fun getDetail(id: String): Flow<List<EntityDetail>> {
        return dao.getDetail(id)
    }
    fun getSearch(name: String): Flow<List<EntitySearch>> = dao.getSearch(name)
    fun getArea(): Flow<List<Entity>> = dao.getArea()
    fun getAreaList(): Flow<List<EntityMain>> = dao.getAreaList()

    suspend fun insertCategory(entityCategory: List<EntityCategory>) = dao.insertCategory(entityCategory)
    suspend fun insertSearch(entitySearch: List<EntitySearch>) = dao.insertSearch(entitySearch)
    suspend fun insertDetail(entityDetail: List<EntityDetail>) = dao.insertDetail(entityDetail)
    suspend fun insertMain(entityMain: List<EntityMain>) = dao.insertMain(entityMain)
    suspend fun insert(entity: List<EntityCategoryMeal>) = dao.insert(entity)
    suspend fun insertArea(entity: List<Entity>) = dao.insertArea(entity)
    suspend fun insertAreaList(entityMain: List<EntityMain>) =dao.insertAreaList(entityMain)

    fun setFavorite(status: Boolean, entityDetail: EntityDetail){
        entityDetail.isFavorite=status
        dao.updateFavorite(entityDetail)
        Log.e("fav", "setFavorite: $entityDetail" )
    }
    fun getFav(): Flow<List<EntityDetail>> = dao.getFav()

}