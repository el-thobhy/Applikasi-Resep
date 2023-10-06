package com.elthobhy.applikasiresep.core.data.source

import com.elthobhy.applikasiresep.core.data.source.local.LocalDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.RemoteDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import com.elthobhy.applikasiresep.core.data.source.remote.response.CategoriesItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemDetail
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemMain
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemSearch
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import com.elthobhy.applikasiresep.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
): RepositoryInterface {

    override fun getArea(): Flow<Resource<List<DomainArea>>> =
        object : NetworkBoundResource<List<DomainArea>, List<MealsItem>>(){
            override fun loadFromDB(): Flow<List<DomainArea>> {
                return local.getArea().map { DataMapper.entityAreaToDomainArea(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItem>>> {
                return remote.getListArea()
            }

            override suspend fun saveCallResult(data: List<MealsItem>) {
                val dataMap = DataMapper.responAreaToEntityArea(data)
                return local.insert(dataMap)
            }

            override fun shouldFetch(data: List<DomainArea>?): Boolean {
                return data == null || data.isEmpty()
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

}