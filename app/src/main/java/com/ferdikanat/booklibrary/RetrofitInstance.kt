package com.ferdikanat.booklibrary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GoogleBooksApiService by lazy {
        retrofit.create(GoogleBooksApiService::class.java)
    }
}
