package com.hoshii.lib.ui

import java.util.Locale

val String.wordCount: Int get() = this.split(" ").count()

fun String.capitalize(locale: Locale = Locale.getDefault()) =
    this.lowercase().replaceFirstChar { it.titlecase(locale) }

inline fun String.ifNotEmpty(block: (String) -> Unit) {
    if (isNotEmpty()) block(this)
}

fun List<String>.filterNotEmpty() = filter { it.isNotEmpty() }