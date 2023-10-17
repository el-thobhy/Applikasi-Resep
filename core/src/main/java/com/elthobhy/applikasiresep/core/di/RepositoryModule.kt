package com.elthobhy.applikasiresep.core.di

import com.elthobhy.applikasiresep.core.data.source.Repository
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun repo(repository: Repository): RepositoryInterface
}