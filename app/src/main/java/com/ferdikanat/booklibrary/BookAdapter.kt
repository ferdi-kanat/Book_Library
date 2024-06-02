package com.ferdikanat.booklibrary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ferdikanat.booklibrary.databinding.ItemBookBinding

class BookAdapter(private val clickListener: (Book) -> Unit) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var books: List<Book> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(bookList: List<Book>) {
        books = bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position], clickListener)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book, clickListener: (Book) -> Unit) {
            binding.book = book
            binding.root.setOnClickListener { clickListener(book) }
            binding.executePendingBindings()
        }
    }
}
