package com.example.mvvm.di

import com.example.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Alcance de la instancia del módulo -> Activity
object NetworkModule {

    @Singleton // Singleton para evitar múltiples instancias del mismo objeto
    @Provides // Proporciona una instancia de Retrofit
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-6e6ff6-quote23.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}