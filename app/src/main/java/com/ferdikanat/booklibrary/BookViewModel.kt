package com.ferdikanat.booklibrary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BookViewModel(application: Application, private val repository: BookRepository) : AndroidViewModel(application) {

    val allBooks: LiveData<List<Book>>

    init {
        allBooks = repository.allBooks
    }

    fun fetchBooks(query: String) = viewModelScope.launch {
        repository.fetchBooks(query)
    }
}
