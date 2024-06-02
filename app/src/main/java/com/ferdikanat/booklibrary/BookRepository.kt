package com.ferdikanat.booklibrary

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository(private val api: GoogleBooksApiService, private val bookDao: BookDao) {

    val allBooks: LiveData<List<Book>> = bookDao.getAllBooks()

    suspend fun fetchBooks(query: String) {
        withContext(Dispatchers.IO) {
            val response = api.getBooks(query)
            response.items.forEach { item ->
                val thumbnail = item.volumeInfo.imageLinks?.thumbnail ?: ""
                Log.d("BookRepository", "Thumbnail URL: $thumbnail")
                val book = Book(
                    id = 0,
                    title = item.volumeInfo.title,
                    authors = item.volumeInfo.authors.joinToString(", "),
                    thumbnail = thumbnail ,
                    description = item.volumeInfo.description,
                    publisher = item.volumeInfo.publisher,
                    publishedDate = item.volumeInfo.publishedDate
                )
                bookDao.insert(book)
            }
        }
    }

}
