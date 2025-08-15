package com.example.mvvm.domain.model

import com.example.mvvm.data.database.entities.QuoteEntity
import com.example.mvvm.data.model.QuoteModel

data class Quote(
    val quote: String,
    val author: String
)

fun QuoteModel.toDomainFromModel() = Quote(quote, author)

fun QuoteEntity.toDomainFromEntity() = Quote(quote, author)