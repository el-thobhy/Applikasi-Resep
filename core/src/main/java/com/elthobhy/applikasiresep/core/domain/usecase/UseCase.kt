package com.elthobhy.applikasiresep.core.domain.usecase

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getArea(): Flow<Resource<List<DomainArea>>>
}