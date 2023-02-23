package com.hoshii.lib.local_db.adapters

import app.cash.sqldelight.EnumColumnAdapter
import app.cash.sqldelight.adapter.primitive.FloatColumnAdapter
import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import com.hoshii.lib.localdb.EntryEntity
import com.hoshii.lib.localdb.RecurringEntity
import com.hoshii.lib.localdb.SkillEntity
import com.hoshii.lib.localdb.TaskEntity

internal val entryEntityAdapter = EntryEntity.Adapter(
    typeAdapter = EnumColumnAdapter(),
    progressAdapter = IntColumnAdapter,
    priorityAdapter = IntColumnAdapter,
    childrenIdsAdapter = LongListAdapter(),
    parentsAdapter = ParentListAdapter(),
)

internal val recurringEntityAdapter = RecurringEntity.Adapter(
    recurrenceTypeAdapter = EnumColumnAdapter(),
    weekDaysAdapter = WeekDayListAdapter(),
    daysOfMonthAdapter = IntListAdapter(),
    daysIntervalAdapter = IntColumnAdapter,
)

internal val taskEntityAdapter = TaskEntity.Adapter(
    monetaryCostAdapter = FloatColumnAdapter,
    physicalEnergyCostAdapter = EnumColumnAdapter(),
    mentalEnergyCostAdapter = EnumColumnAdapter(),
    timeOfFinishAdapter = IntColumnAdapter,
    timeOfStartAdapter = IntColumnAdapter,
)

internal val skillEntityAdapter = SkillEntity.Adapter(
    levelAdapter = IntColumnAdapter,
)
