package com.example.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-6e6ff6-quote23.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}