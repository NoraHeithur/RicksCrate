package com.nora.rickscrate.data.util

import android.net.Uri

fun nextPage(nextPage: String?): Int? {
    return if (nextPage != null) {
        val uri = Uri.parse(nextPage)
        val pageQuery = uri.getQueryParameter("page")
        pageQuery?.toInt()
    } else {
        null
    }
}