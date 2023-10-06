package com.elthobhy.applikasiresep.core.domain.usecase

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import kotlinx.coroutines.flow.Flow

class RepositoryInteract(private val repo: RepositoryInterface) : UseCase {
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
    ): Flow<Resource<List<DomainMeal>>> = repo.getListCategory(
        strCategory,
        isBeef,
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
        isVegetarian,
    )

    override fun getMain(): Flow<Resource<List<DomainMain>>> = repo.getMain()
    override fun getDetail(id: String): Flow<Resource<List<DomainDetail>>> = repo.getDetail(id)
    override fun getSearch(name: String): Flow<Resource<List<DomainSearch>>> = repo.getSearch(name)
    override fun getCategory(): Flow<Resource<List<DomainCategory>>> = repo.getCategory()


}