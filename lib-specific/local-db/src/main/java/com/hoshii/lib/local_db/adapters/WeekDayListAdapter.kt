package com.hoshii.lib.local_db.adapters

import app.cash.sqldelight.ColumnAdapter
import com.hoshii.lib.local_db.models.WeekDay

internal class WeekDayListAdapter : ColumnAdapter<List<WeekDay>, String> {
    override fun decode(databaseValue: String): List<WeekDay> =
        databaseValue.split(",").mapNotNull { WeekDay.parse(it) }

    override fun encode(value: List<WeekDay>): String =
        value.joinToString(",") { it.name }
}