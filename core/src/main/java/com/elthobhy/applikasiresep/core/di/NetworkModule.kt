package com.elthobhy.applikasiresep.core.di

import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiConfig
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun apiConfig(): ApiService {
        return  ApiConfig.getApiService()
    }
}