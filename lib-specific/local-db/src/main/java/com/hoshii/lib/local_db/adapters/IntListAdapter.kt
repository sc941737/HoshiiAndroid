package com.hoshii.lib.local_db.adapters

import app.cash.sqldelight.ColumnAdapter

internal class IntListAdapter : ColumnAdapter<List<Int>, String> {
    override fun decode(databaseValue: String): List<Int> =
        databaseValue.split(",").map { it.ifEmpty { "0" }.toInt() }

    override fun encode(value: List<Int>): String =
        value.joinToString(separator = ",")
}