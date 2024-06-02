package com.ferdikanat.booklibrary

import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): BookResponse
}
