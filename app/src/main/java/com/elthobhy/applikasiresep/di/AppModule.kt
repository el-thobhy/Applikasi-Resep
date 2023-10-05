package com.elthobhy.applikasiresep.di

import com.elthobhy.applikasiresep.ui.area.AreaViewModel
import com.elthobhy.applikasiresep.core.domain.usecase.RepositoryInteract
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import com.elthobhy.applikasiresep.ui.detail.DetailViewModel
import com.elthobhy.applikasiresep.ui.home.AdapterPopular
import com.elthobhy.applikasiresep.ui.home.HomeViewModel
import org.koin.dsl.module

val useCase = module {
    factory<UseCase> { RepositoryInteract(get()) }
}

val viewModel = module {
    single { AreaViewModel(get()) }
    single { HomeViewModel(get()) }
    single { DetailViewModel(get()) }
}
val adapter = module {
    single { AdapterPopular() }
}