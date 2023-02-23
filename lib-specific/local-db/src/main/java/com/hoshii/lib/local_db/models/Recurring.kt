package com.hoshii.lib.local_db.models

interface Recurring {
    val recurrenceType: RecurrenceType
    val daysInterval: Int
    val weekDays: List<WeekDay>
    val daysOfMonth: List<Int> // 1-31 or <= last
    val manualProgress: Boolean // Recurring tasks can have progress calculated automatically from the deadline
}

enum class RecurrenceType {
    EVERYDAY,
    DAYS,
    DAY_OF_WEEK,
    DAY_OF_MONTH,
}

enum class WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    companion object {
        fun parse(s: String) = WeekDay.values().find { it.name == s }
    }
}