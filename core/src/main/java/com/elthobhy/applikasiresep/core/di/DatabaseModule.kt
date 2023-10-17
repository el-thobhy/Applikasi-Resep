package com.elthobhy.applikasiresep.core.di

import android.content.Context
import androidx.room.Room
import com.elthobhy.applikasiresep.core.data.source.local.room.Dao
import com.elthobhy.applikasiresep.core.data.source.local.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java, "resep_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDao(database: Database): Dao {
        return database.dao()
    }
}