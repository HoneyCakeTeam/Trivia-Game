package com.honey.triviagame.ui.util

import java.util.Locale

fun String.toTitleCase(): String {
    val words = this.split("_")
    val titleCaseWords = words.map { word ->
        word.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.ROOT) else it.toString()
        }
    }
    return titleCaseWords.joinToString(" ")
}