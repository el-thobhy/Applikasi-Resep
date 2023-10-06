package com.elthobhy.applikasiresep.core.domain.usecase

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainArea
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import kotlinx.coroutines.flow.Flow

class RepositoryInteract(private val repo: RepositoryInterface): UseCase {
    override fun getArea(): Flow<Resource<List<DomainArea>>> = repo.getArea()
    override fun getMain(): Flow<Resource<List<DomainMain>>> = repo.getMain()
    override fun getDetail(id: String): Flow<Resource<List<DomainDetail>>> = repo.getDetail(id)
    override fun getSearch(name: String): Flow<Resource<List<DomainSearch>>> = repo.getSearch(name)
}