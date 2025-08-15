package com.example.mvvm.data

import com.example.mvvm.data.database.dao.QuoteDao
import com.example.mvvm.data.database.entities.QuoteEntity
import com.example.mvvm.data.network.QuoteService
import com.example.mvvm.domain.model.Quote
import com.example.mvvm.domain.model.toDomainFromEntity
import com.example.mvvm.domain.model.toDomainFromModel
import javax.inject.Inject

class QuoteRepository @Inject constructor(val quoteService: QuoteService, val quoteDao: QuoteDao)  {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = quoteService.getQuotes()
        val response2: List<Quote> = response.map { it.toDomainFromModel() }
        return response2
        // return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDataBase(): List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        val response2: List<Quote> = response.map { it.toDomainFromEntity() }
        return response2
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}