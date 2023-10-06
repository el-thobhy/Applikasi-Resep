package com.elthobhy.applikasiresep.core.domain.repository

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import kotlinx.coroutines.flow.Flow


interface RepositoryInterface {
    fun getArea(): Flow<Resource<List<DomainArea>>>
    fun getMain(): Flow<Resource<List<DomainMain>>>
    fun getDetail(id: String): Flow<Resource<List<DomainDetail>>>
    fun getSearch(name: String): Flow<Resource<List<DomainSearch>>>
}