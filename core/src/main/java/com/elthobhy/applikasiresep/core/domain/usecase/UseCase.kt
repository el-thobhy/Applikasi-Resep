package com.elthobhy.applikasiresep.core.domain.usecase

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getArea(): Flow<Resource<List<DomainArea>>>
    fun getMain(): Flow<Resource<List<DomainMain>>>
    fun getDetail(id: String): Flow<Resource<List<DomainDetail>>>
    fun getSearch(name: String): Flow<Resource<List<DomainSearch>>>
    fun getCategory(): Flow<Resource<List<DomainCategory>>>
}