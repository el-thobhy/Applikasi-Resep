package com.elthobhy.applikasiresep.core.domain.repository

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainPopular
import kotlinx.coroutines.flow.Flow


interface RepositoryInterface {
    fun getArea(): Flow<Resource<List<DomainArea>>>
    fun getPopular(): Flow<Resource<List<DomainPopular>>>
    fun getDetail(id: String): Flow<Resource<List<DomainDetail>>>
}