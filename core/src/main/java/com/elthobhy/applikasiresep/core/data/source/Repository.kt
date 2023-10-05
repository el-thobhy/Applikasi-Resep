package com.elthobhy.applikasiresep.core.data.source

import com.elthobhy.applikasiresep.core.data.source.local.LocalDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.RemoteDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemDetail
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemPopular
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainPopular
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

    override fun getPopular(): Flow<Resource<List<DomainPopular>>> =
        object : NetworkBoundResource<List<DomainPopular>, List<MealsItemPopular>>(){
            override fun loadFromDB(): Flow<List<DomainPopular>> {
                return local.getPopular().map { DataMapper.entityPopularToDomainPopular(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MealsItemPopular>>> {
                return remote.getListPopular()
            }

            override suspend fun saveCallResult(data: List<MealsItemPopular>) {
                val dataMap = DataMapper.responPopularToEntityPopular(data)
                return local.insertPopular(dataMap)
            }

            override fun shouldFetch(data: List<DomainPopular>?): Boolean {
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


}