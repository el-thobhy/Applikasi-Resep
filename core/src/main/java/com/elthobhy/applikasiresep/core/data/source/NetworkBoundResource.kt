package com.elthobhy.applikasiresep.core.data.source

import android.util.Log
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    Log.e("Check", ": ${apiResponse.data}" )
                    emitAll(loadFromDB().map {
                        Resource.success(
                            it
                        )
                    })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map {
                        Resource.success(
                            it
                        )
                    })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(
                        Resource.error(
                            apiResponse.message
                        )
                    )
                }
            }
        } else {
            emitAll(loadFromDB().map {
                Resource.success(
                    it
                )
            })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}