package com.elthobhy.applikasiresep.di

import com.elthobhy.applikasiresep.area.AreaViewModel
import com.elthobhy.applikasiresep.core.domain.usecase.RepositoryInteract
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import org.koin.dsl.module

val useCase = module {
    factory<UseCase> { RepositoryInteract(get()) }
}

val viewModel = module {
    single { AreaViewModel(get()) }
}