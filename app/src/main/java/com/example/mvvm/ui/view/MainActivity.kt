package com.example.mvvm.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModelLiveData.observe(this, Observer {
            if (it != null) { binding.tvQuote.text = it.quote }
            else { binding.tvQuote.text = R.string.error_quote.toString() }

            if (it != null) {
                binding.tvAuthor.text = it.author
            } else {
                binding.tvAuthor.text = R.string.error_author.toString()
            }
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}