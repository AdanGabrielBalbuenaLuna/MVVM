package com.example.mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.mvvm.data.database.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val QUOTE_DATABASE_NAME ="quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext contexts: Context) = Room.databaseBuilder(contexts,
        QuoteDataBase::class.java, QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDataBase) = db.getQuoteDao()
}