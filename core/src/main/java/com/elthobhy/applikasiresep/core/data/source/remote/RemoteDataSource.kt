package com.elthobhy.applikasiresep.core.data.source.remote

import android.util.Log
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiConfig
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import com.elthobhy.applikasiresep.core.data.source.remote.response.CategoriesItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemDetail
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemMain
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource {
    suspend fun getListCategory(strCategory: String) : Flow<ApiResponse<List<MealsItemMain>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getListCategory(strCategory)
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

    suspend fun getListMain() : Flow<ApiResponse<List<MealsItemMain>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getMain("American")
                val list = response.meals
                if(list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                    Log.e("response", "getListMain: $list" )
                }else{
                    emit(ApiResponse.Empty)
                    Log.e("response kosong", "getListMain: $list" )
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getDetail(id: String) : Flow<ApiResponse<List<MealsItemDetail>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getDetail(id)
                val list = response.meals
                if(list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                    Log.e("response", "getDetail: $list" )
                }else{
                    emit(ApiResponse.Empty)
                    Log.e("response kosong", "getDetail: $list" )
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getSearch(name: String) : Flow<ApiResponse<List<MealsItemSearch>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getSearch(name)
                val list = response.meals
                if(list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                    Log.e("response", "getSearch: $list" )
                }else{
                    emit(ApiResponse.Empty)
                    Log.e("response kosong", "getListSearcg: $list" )
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getCategory() : Flow<ApiResponse<List<CategoriesItem>>> {
        return flow {
            try {
                val response = ApiConfig.getApiService().getCategory()
                val list = response.categories
                if(list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                    Log.e("response", "getCategory: $list" )
                }else{
                    emit(ApiResponse.Empty)
                    Log.e("response kosong", "getCategory: $list" )
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}