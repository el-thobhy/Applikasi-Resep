package com.elthobhy.applikasiresep.core.data.source.remote.network

import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseCategory
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseDetailMeal
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseListArea
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseListPopular
import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list.php")
    suspend fun getArea(
        @Query("a") a: String
    ): ResponseListArea

    @GET("filter.php")
    suspend fun getMain(
        @Query("a") a: String
    ): ResponseListPopular

    @GET("lookup.php")
    suspend fun getDetail(
        @Query("i") i: String
    ): ResponseDetailMeal

    @GET("search.php")
    suspend fun getSearch(
        @Query("s") s: String
    ): ResponseSearch

    @GET("categories.php")
    suspend fun getCategory(): ResponseCategory
}