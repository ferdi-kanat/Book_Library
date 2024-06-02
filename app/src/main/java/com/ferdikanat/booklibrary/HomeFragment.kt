package com.ferdikanat.booklibrary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ferdikanat.booklibrary.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: BookViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val application = requireNotNull(this.activity).application
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        val repository = BookRepository(RetrofitInstance.api, bookDao)
        val factory = ViewModelFactory(application, repository)

        viewModel = ViewModelProvider(this, factory)[BookViewModel::class.java]

        val adapter = BookAdapter { book ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(book)
            findNavController().navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.allBooks.observe(viewLifecycleOwner) { books ->
            adapter.submitList(books)
        }

        viewModel.fetchBooks("Android development")
    }
}
