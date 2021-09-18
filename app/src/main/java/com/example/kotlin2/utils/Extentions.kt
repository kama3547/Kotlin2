package com.example.kotlin2.utils

import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun EditText.getEdText(): String{
    return text.toString().trim()
}

fun EditText.isValid(): String{
    if (getEdText().isEmpty()){
        error = "Incorrect!"
    }
    return getEdText()
}
fun ImageView.loadImage(url: String){
    Picasso.get().load(url).into(this)
}
