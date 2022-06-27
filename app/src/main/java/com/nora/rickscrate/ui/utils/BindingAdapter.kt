package com.nora.rickscrate.ui.utils

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.textview.MaterialTextView
import com.nora.rickscrate.R

@BindingAdapter("imageSrc")
fun AppCompatImageView.imageSrc(url: String) {
    load(url) {
        error(R.drawable.ic_outline_broken_image)
    }
}

@BindingAdapter("goneIfTextIsEmpty")
fun goneItTextIsEmpty(view: View, text: String) {
    view.visibility = if (text.isEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("unknownIfEmpty")
fun MaterialTextView.unknownIfEmpty(displayText: String) {
    text = displayText.ifEmpty {
        resources.getString(R.string.label_unknown)
    }
}