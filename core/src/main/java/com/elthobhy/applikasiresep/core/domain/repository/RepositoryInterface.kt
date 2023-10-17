package com.elthobhy.applikasiresep.core.domain.repository

import com.elthobhy.applikasiresep.core.data.source.Resource
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch
import kotlinx.coroutines.flow.Flow


interface RepositoryInterface {
    fun getListCategory(
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
    ): Flow<Resource<List<DomainMeal>>>
    fun getMain(): Flow<Resource<List<DomainMain>>>
    fun getDetail(id: String): Flow<Resource<List<DomainDetail>>>
    fun getSearch(name: String): Flow<Resource<List<DomainSearch>>>
    fun getCategory(): Flow<Resource<List<DomainCategory>>>
    fun getArea(): Flow<Resource<List<Domain>>>
    fun getAreaList(strArea: String): Flow<Resource<List<DomainMain>>>
    fun setFav(status: Boolean, data: DomainDetail)
    fun getFav(): Flow<List<DomainDetail>>
}