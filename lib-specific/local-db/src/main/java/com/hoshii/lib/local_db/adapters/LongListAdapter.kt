package com.hoshii.lib.local_db.adapters

import app.cash.sqldelight.ColumnAdapter

class LongListAdapter : ColumnAdapter<List<Long>, String> {
    override fun decode(databaseValue: String): List<Long> =
        databaseValue.split(",").map { it.ifEmpty { "0" }.toLong() }

    override fun encode(value: List<Long>): String =
        value.joinToString(separator = ",")
}