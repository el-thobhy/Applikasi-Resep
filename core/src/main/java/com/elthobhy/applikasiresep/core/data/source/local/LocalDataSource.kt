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

class LocalDataSource(private val dao: Dao) {
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
    fun getDetail(id: String): Flow<List<EntityDetail>> = dao.getDetail(id)
    fun getSearch(name: String): Flow<List<EntitySearch>> = dao.getSearch(name)
    fun getArea(): Flow<List<Entity>> = dao.getArea()

    suspend fun insertCategory(entityCategory: List<EntityCategory>) = dao.insertCategory(entityCategory)
    suspend fun insertSearch(entitySearch: List<EntitySearch>) = dao.insertSearch(entitySearch)
    suspend fun insertDetail(entityDetail: List<EntityDetail>) = dao.insertDetail(entityDetail)
    suspend fun insertMain(entityMain: List<EntityMain>) = dao.insertMain(entityMain)
    suspend fun insert(entity: List<EntityCategoryMeal>) = dao.insert(entity)
    suspend fun insertArea(entity: List<Entity>) = dao.insertArea(entity)
/*    fun setStatus(data: List<EntityCategoryMeal>, status: Boolean, cat: String) {
        when (cat) {
            "Starter" -> {
                data.map {
                    it.isStarter=status
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Beef" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=status
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Breakfast" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=status
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Chicken" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=status
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Dessert" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=status
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Goat" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=status
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Lamb" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=status
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Miscellaneous" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=status
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Pasta" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=status
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Pork" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=status
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Seafood" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=status
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Side" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=status
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Vegan" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=status
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=false
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
            "Vegetarian" -> {
                data.map {
                    it.isStarter=false
                    it.isGoat=false
                    it.isBeef=false
                    it.isVegan=false
                    it.isBreakfast=false
                    it.isChicken=false
                    it.isDessert=false
                    it.isLamb=false
                    it.isMiscellaneous=false
                    it.isPasta=false
                    it.isPork=false
                    it.isSeafood=false
                    it.isSide=false
                    it.isVegetarian=status
                }
                dao.updateStatusStarter(data)
                Log.e("lolol", "setStatus: $data", )
            }
        }

        }
    fun getCat(cat: String): Flow<List<EntityCategoryMeal>> {
       return when(cat){
           "Starter"->dao.getStarter()
           "Beef"->dao.getBeef()
           "Breakfast"-> dao.getBreakfast()
           "Chicken"->dao.getChicken()
           "Dessert"-> dao.getDessert()
           "Goat"->dao.getGoat()
           "Lamb"-> dao.getLamb()
           "Miscellaneous"->dao.getMiscellaneous()
           "Pasta"-> dao.getPasta()
           "Pork"->dao.getPork()
           "Seafood"-> dao.getSeafood()
           "Side"->dao.getSide()
           "Vegan"-> dao.getVegan()
           "Vegetarian"->dao.getVegetarian()
           else->dao.getGoat()
       }
    }*/

}