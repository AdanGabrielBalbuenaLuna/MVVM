package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(val quoteProvider: QuoteProvider) {
    //private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (quotes.isNotEmpty()) {
            // val randomNumber = (0..quotes.size-1).random()
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}