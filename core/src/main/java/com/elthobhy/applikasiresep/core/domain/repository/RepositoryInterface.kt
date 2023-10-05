package com.elthobhy.applikasiresep.core.domain.repository

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import kotlinx.coroutines.flow.Flow


interface RepositoryInterface {
    fun getArea(): Flow<Resource<List<DomainArea>>>
}