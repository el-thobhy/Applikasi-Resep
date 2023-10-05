package com.elthobhy.applikasiresep.core.utils

import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityArea
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.domain.model.DomainArea

object DataMapper {
    fun entityAreaToDomainArea(input: List<EntityArea>): List<DomainArea>{
        val out = ArrayList<DomainArea>()
        input.map {
            val list = DomainArea(
                strArea = it.strArea
            )
            out.add(list)
        }
        return out
    }

    fun responAreaToEntityArea(input: List<MealsItem>): List<EntityArea>{
        val out = ArrayList<EntityArea>()
        input.map {
            val list = EntityArea(
                strArea = it.strArea
            )
            out.add(list)
        }
        return out
    }
}