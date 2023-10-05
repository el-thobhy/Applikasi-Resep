package com.elthobhy.applikasiresep.core.di

import androidx.room.Room
import com.elthobhy.applikasiresep.core.data.source.Repository
import com.elthobhy.applikasiresep.core.data.source.local.LocalDataSource
import com.elthobhy.applikasiresep.core.data.source.local.room.Database
import com.elthobhy.applikasiresep.core.data.source.remote.RemoteDataSource
import com.elthobhy.applikasiresep.core.data.source.remote.network.ApiConfig
import com.elthobhy.applikasiresep.core.domain.repository.RepositoryInterface
import com.elthobhy.applikasiresep.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val network = module {
    single { ApiConfig }
}
val repository = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource() }
    factory { AppExecutors() }
    single<RepositoryInterface> { Repository(get(),get()) }
}
val database = module {
    factory { get<Database>().dao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java, "area_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}