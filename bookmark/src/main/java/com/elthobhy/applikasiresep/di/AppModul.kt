package com.elthobhy.applikasiresep.di

import com.elthobhy.applikasiresep.core.domain.usecase.RepositoryInteract
import com.elthobhy.applikasiresep.core.domain.usecase.UseCase
import com.elthobhy.applikasiresep.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val favoriteModule = module {
    viewModel {
        FavoriteViewModel(get())
    }
}