package com.elthobhy.applikasiresep.core.data.source

import android.util.Log
import com.elthobhy.applikasiresep.core.data.source.local.LocalDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.RemoteDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import com.elthobhy.applikasiresep.core.data.source.remote.response.CategoriesItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemDetail
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemMain
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemSearch
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import com.elthobhy.applikasiresep.core.utils.AppExecutors
import com.elthobhy.applikasiresep.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val appExecutors: AppExecutors
): RepositoryInterface {

    override fun getListCategory(
        strCategory: String,
        isBeef: Boolean,
        isBreakfast: Boolean,
        isChicken: Boolean,
        isDessert: Boolean,
        isGoat: Boolean,
        isLamb: Boolean,
        isMiscellaneous: Boolean,
        isPasta: Boolean,
        isPork: Boolean,
        isSeafood: Boolean,
        isSide: Boolean,
        isStarter: Boolean,
        isVegan: Boolean,
        isVegetarian: Boolean,
    ): Flow<Resource<List<DomainMeal>>> =
        object : NetworkBoundResource<List<DomainMeal>, List<MealsItemMain>>(){
            override fun loadFromDB(): Flow<List<DomainMeal>> {
                return when {
                    isBeef-> local.getBeef().map { DataMapper.entityMealToDomainMeal(it) }
                    isBreakfast-> local.getBreakfast().map { DataMapper.entityMealToDomainMeal(it) }
                    isChicken-> local.getChicken().map { DataMapper.entityMealToDomainMeal(it) }
                    isDessert-> local.getDessert().map { DataMapper.entityMealToDomainMeal(it) }
                    isGoat-> local.getGoat().map { DataMapper.entityMealToDomainMeal(it) }
                    isLamb-> local.getLamb().map { DataMapper.entityMealToDomainMeal(it) }
                    isMiscellaneous-> local.getMiscellaneous().map { DataMapper.entityMealToDomainMeal(it) }
                    isPasta-> local.getPasta().map { DataMapper.entityMealToDomainMeal(it) }
                    isPork-> local.getPork().map { DataMapper.entityMealToDomainMeal(it) }
                    isSeafood-> local.getSeafood().map { DataMapper.entityMealToDomainMeal(it) }
                    isSide-> local.getSide().map { DataMapper.entityMealToDomainMeal(it) }
                    isStarter-> local.getStarter().map { DataMapper.entityMealToDomainMeal(it) }
                    isVegan-> local.getVegan().map { DataMapper.entityMealToDomainMeal(it) }
                    isVegetarian-> local.getVegetarian().map { DataMapper.entityMealToDomainMeal(it) }
                    else->local.getGoat().map { DataMapper.entityMealToDomainMeal(it) }

                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemMain>>> {
                return remote.getListCategory(strCategory)
            }

            override suspend fun saveCallResult(data: List<MealsItemMain>) {
                val dataMap = DataMapper.responMealToEntityMeal(data, isBeef,
                    isBreakfast,
                    isChicken,
                    isDessert,
                    isGoat,
                    isLamb,
                    isMiscellaneous,
                    isPasta,
                    isPork,
                    isSeafood,
                    isSide,
                    isStarter,
                    isVegan,
                    isVegetarian,)
                return local.insert(dataMap)
            }

            override fun shouldFetch(data: List<DomainMeal>?): Boolean {
                return true
            }
        }.asFlow()

    override fun getMain(): Flow<Resource<List<DomainMain>>> =
        object : NetworkBoundResource<List<DomainMain>, List<MealsItemMain>>(){
            override fun loadFromDB(): Flow<List<DomainMain>> {
                return local.getMain().map { DataMapper.entityMainToDomainMain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemMain>>> {
                return remote.getListMain()
            }

            override suspend fun saveCallResult(data: List<MealsItemMain>) {
                val dataMap = DataMapper.responMainToEntityMain(data)
                return local.insertMain(dataMap)
            }

            override fun shouldFetch(data: List<DomainMain>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun getDetail(id: String): Flow<Resource<List<DomainDetail>>> =
        object : NetworkBoundResource<List<DomainDetail>, List<MealsItemDetail>>(){
            override fun loadFromDB(): Flow<List<DomainDetail>> {
                return local.getDetail(id).map { DataMapper.entityDetailToDomainDetail(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemDetail>>> {
                return remote.getDetail(id)
            }

            override suspend fun saveCallResult(data: List<MealsItemDetail>) {
                val dataMap = DataMapper.responDetailToEntityDetail(data)
                return local.insertDetail(dataMap)
            }

            override fun shouldFetch(data: List<DomainDetail>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun getSearch(name: String): Flow<Resource<List<DomainSearch>>> =
        object : NetworkBoundResource<List<DomainSearch>, List<MealsItemSearch>>(){
            override fun loadFromDB(): Flow<List<DomainSearch>> {
                return local.getSearch(name).map { DataMapper.entitySearchToDomainSearch(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemSearch>>> {
                return remote.getSearch(name)
            }

            override suspend fun saveCallResult(data: List<MealsItemSearch>) {
                val dataMap = DataMapper.responSearchToEntitySearch(data)
                return local.insertSearch(dataMap)
            }

            override fun shouldFetch(data: List<DomainSearch>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun getCategory(): Flow<Resource<List<DomainCategory>>> =
        object : NetworkBoundResource<List<DomainCategory>, List<CategoriesItem>>(){
            override fun loadFromDB(): Flow<List<DomainCategory>> {
                return local.getCategory().map { DataMapper.entityCategoryToDomainCategory(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<CategoriesItem>>> {
                return remote.getCategory()
            }

            override suspend fun saveCallResult(data: List<CategoriesItem>) {
                val dataMap = DataMapper.responCategoryToEntityCategory(data)
                return local.insertCategory(dataMap)
            }

            override fun shouldFetch(data: List<DomainCategory>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun getArea(): Flow<Resource<List<Domain>>> =
        object : NetworkBoundResource<List<Domain>, List<MealsItem>>(){
            override fun loadFromDB(): Flow<List<Domain>> {
                return local.getArea().map { DataMapper.entityToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItem>>> {
                return remote.getArea()
            }

            override suspend fun saveCallResult(data: List<MealsItem>) {
                val dataMap = DataMapper.responToEntity(data)
                return local.insertArea(dataMap)
            }

            override fun shouldFetch(data: List<Domain>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun getAreaList(strArea: String): Flow<Resource<List<DomainMain>>> =
        object : NetworkBoundResource<List<DomainMain>, List<MealsItemMain>>(){
            override fun loadFromDB(): Flow<List<DomainMain>> {
                return local.getAreaList().map { DataMapper.entityMainToDomainMain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemMain>>> {
                return remote.getAreaList(strArea)
            }

            override suspend fun saveCallResult(data: List<MealsItemMain>) {
                val dataMap = DataMapper.responMainToEntityMain(data)
                return local.insertAreaList(dataMap)
            }

            override fun shouldFetch(data: List<DomainMain>?): Boolean {
                return data == null || data.isEmpty()
            }
        }.asFlow()

    override fun setFav(status: Boolean, data: DomainDetail) {
        val entity = DataMapper.domainToEntity(data)
        appExecutors.diskIO().execute{
            entity?.let { local.setFavorite(status, it) }
            Log.e("cihuy", "setFav: $entity" )
        }
    }

    override fun getFav(): Flow<List<DomainDetail>> =
        local.getFav().map {
            DataMapper.entityDetailToDomainDetail(it)
        }



}