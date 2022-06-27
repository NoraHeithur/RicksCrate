package com.nora.rickscrate.ui.utils

fun removePrefixOfListMember(prefix: String, prefixedList: List<String>): List<String> {
    val removedPrefixList = mutableListOf<String>()

    return if (prefixedList.isEmpty()) {
        removedPrefixList.toList()
    } else {
        for (e in prefixedList) {
            removedPrefixList.add(e.removePrefix(prefix))
        }
        removedPrefixList.toList()
    }
}