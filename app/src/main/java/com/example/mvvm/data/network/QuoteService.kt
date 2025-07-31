package com.example.mvvm.data.network

import com.example.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val quoteApiClient: QuoteApiClient) {

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            //val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            val response = quoteApiClient.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}