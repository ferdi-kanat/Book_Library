package com.ferdikanat.booklibrary

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "books")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val authors: String,
    val thumbnail: String,
    val description: String?,
    val publisher: String?,
    val publishedDate: String?
) : Serializable
