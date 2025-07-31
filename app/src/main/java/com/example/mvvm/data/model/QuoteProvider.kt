package com.example.mvvm.data.model

import java.util.Collections.emptyList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}