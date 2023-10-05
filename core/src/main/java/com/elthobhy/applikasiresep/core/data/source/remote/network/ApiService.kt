package com.elthobhy.applikasiresep.core.data.source.remote.network

import com.elthobhy.applikasiresep.core.data.source.remote.response.ResponseListArea
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("list.php")
    suspend fun getArea(
        @Query("a") a: String
    ): ResponseListArea

}