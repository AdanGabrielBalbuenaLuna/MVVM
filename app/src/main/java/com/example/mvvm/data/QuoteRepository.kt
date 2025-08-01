package com.example.mvvm.data

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(val quoteService: QuoteService, val quoteProvider: QuoteProvider)  {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = quoteService.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}