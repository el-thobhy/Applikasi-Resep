package com.elthobhy.applikasiresep.di

import com.elthobhy.applikasiresep.core.domain.usecase.RepositoryInteract
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModuleHilt {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(repositoryInteract: RepositoryInteract): UseCase
}