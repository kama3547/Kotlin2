package com.example.kotlin2.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    val list: MutableLiveData<ArrayList<String>> = MutableLiveData()
}