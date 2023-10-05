package com.elthobhy.applikasiresep.core.data.source.remote.network

import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseDetailMeal
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseListArea
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseListPopular
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list.php")
    suspend fun getArea(
        @Query("a") a: String
    ): ResponseListArea

    @GET("filter.php")
    suspend fun getPopular(
        @Query("a") a: String
    ): ResponseListPopular

    @GET("lookup.php")
    suspend fun getDetail(
        @Query("i") i: String
    ): ResponseDetailMeal
}