package com.nora.rickscrate.ui.utils

import android.content.Context
import android.graphics.Color
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import com.google.android.material.textview.MaterialTextView

@ColorInt
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.MAGENTA)
    }
}