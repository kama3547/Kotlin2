package com.example.kotlin2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2.R
import com.example.kotlin2.databinding.FragmentRandomBinding
import com.example.kotlin2.utils.getEdText
import com.example.kotlin2.utils.loadImage
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class FragmentRandom : Fragment(R.layout.fragment_random) {

    private val binding by viewBinding(FragmentRandomBinding::bind)
    private var photos: ArrayList<String> = ArrayList()
    private val viewModel: GalleryViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListener()
    }

    private fun clickListener() {
        binding.submitBtn.setOnClickListener {
            val image = binding.edittext.getEdText()
            photos.add(image)
            binding.edittext.setText("")
        }

        binding.randomBtn.setOnClickListener {
            val random = Random().nextInt(photos.size)
            setImage(photos[random])
        }
    }

    private fun initView() {
        photos = arrayListOf(
            getString(R.string.car1),
            getString(R.string.car2),
            getString(R.string.car3),
            getString(R.string.car4),
            getString(R.string.car5)
        )
        viewModel.list.value = photos
    }

    private fun setImage(url: String) {
        binding.imageView.loadImage(url)
    }
}

