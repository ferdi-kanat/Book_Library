package com.ferdikanat.booklibrary

data class BookResponse(
    val items: List<BookItem>
)

data class BookItem(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val imageLinks: ImageLinks?,
    val description: String,
    val publisher: String,
    val publishedDate: String
)

data class ImageLinks(
    val thumbnail: String?
)
