package com.elthobhy.applikasiresep.core.data.source.remote

import android.util.Log
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiConfig
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource {
    suspend fun getListArea() : Flow<ApiResponse<List<MealsItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getArea("list")
                val list = response.meals
                if(list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                    Log.e("response", "getListArea: $list" )
                }else{
                    emit(ApiResponse.Empty)
                    Log.e("response kosong", "getListArea: $list" )
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}