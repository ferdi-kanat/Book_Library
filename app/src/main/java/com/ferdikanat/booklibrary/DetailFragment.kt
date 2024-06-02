package com.ferdikanat.booklibrary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ferdikanat.booklibrary.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val book = arguments?.let { DetailFragmentArgs.fromBundle(it).book }
        binding.book = book
    }
}
