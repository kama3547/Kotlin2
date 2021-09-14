package com.example.kotlin2.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2.R
import com.example.kotlin2.databinding.ActivityMainBinding
import com.example.kotlin2.databinding.FragmentGalleryBinding
import com.example.kotlin2.ui.adapter.RecyclerAdapter

class FragmentGallery : Fragment(R.layout.fragment_gallery) {

    private val resAdapter = RecyclerAdapter()
    private  val viewModel: GalleryViewModel by activityViewModels()
    private val binding by viewBinding(FragmentGalleryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }

    private fun setupRequests() {
        viewModel.list.observe(viewLifecycleOwner,{
            Log.e("anime", it.toString())
            resAdapter.addList(it)
        })
    }

    private fun setupRecycler() {
        binding.recycler.apply {
            layoutManager = GridLayoutManager(requireContext(),3)
            adapter = resAdapter
        }
    }
}