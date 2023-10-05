package com.elthobhy.applikasiresep.core.domain.usecase

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import kotlinx.coroutines.flow.Flow

class RepositoryInteract(private val repo: RepositoryInterface): UseCase {
    override fun getArea(): Flow<Resource<List<DomainArea>>> = repo.getArea()

}