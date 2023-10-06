package com.elthobhy.applikasiresep

import android.app.Application
import com.elthobhy.applikasiresep.core.di.database
import com.elthobhy.applikasiresep.core.di.network
import com.elthobhy.applikasiresep.core.di.repository
import com.elthobhy.applikasiresep.di.adapter
import com.elthobhy.applikasiresep.di.useCase
import com.elthobhy.applikasiresep.di.viewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {
    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                network,
                repository,
                database,
                useCase,
                viewModel,
                adapter
            )
        }
    }
}