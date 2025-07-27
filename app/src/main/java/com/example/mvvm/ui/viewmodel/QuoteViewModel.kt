package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.domain.GetQuoteUseCase
import com.example.mvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModelLiveData = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getQuoteUseCase = GetQuoteUseCase()

    // Instancia de segundo caso de uso
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            delay(1500)
            isLoading.postValue(true)
            val result = getQuoteUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModelLiveData.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote!=null){
            quoteModelLiveData.postValue(quote)
        }
        isLoading.postValue(false)
        //val currentQuote = QuoteProvider.random()
        //quoteModelLiveData.postValue(currentQuote)
    }
}