package com.elthobhy.applikasiresep.di

import com.elthobhy.applikasiresep.ui.area.AreaViewModel
import com.elthobhy.applikasiresep.core.domain.usecase.RepositoryInteract
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import com.elthobhy.applikasiresep.ui.detail.DetailViewModel
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryMealAdapter
import com.elthobhy.applikasiresep.ui.detail.detailcatagory.DetailCategoryViewModel
import com.elthobhy.applikasiresep.ui.home.AdapterCategory
import com.elthobhy.applikasiresep.ui.home.AdapterMain
import com.elthobhy.applikasiresep.ui.home.HomeViewModel
import com.elthobhy.applikasiresep.ui.search.AdapterSearch
import com.elthobhy.applikasiresep.ui.search.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module


val useCase = module {
    factory<UseCase> { RepositoryInteract(get()) }
}
@FlowPreview
@ExperimentalCoroutinesApi
val viewModel = module {
    single { AreaViewModel(get()) }
    single { HomeViewModel(get()) }
    single { DetailViewModel(get()) }
    single { SearchViewModel(get()) }
    single { DetailCategoryViewModel(get()) }
}
val adapter = module {
    single { AdapterMain() }
    single { AdapterSearch() }
    single { AdapterCategory() }
    single { DetailCategoryMealAdapter() }
}