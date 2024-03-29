package com.hoshii.lib.local_db

import com.hoshii.lib.local_db.models.Folder
import com.hoshii.lib.local_db.models.RecurringTask
import com.hoshii.lib.local_db.models.SimpleGoal
import com.hoshii.lib.local_db.models.SimpleTask
import com.hoshii.lib.local_db.models.Skill
import com.hoshii.lib.localdb.EntryEntity
import com.hoshii.lib.localdb.GetAllGoals
import com.hoshii.lib.localdb.GetAllRecurringTasks
import com.hoshii.lib.localdb.GetAllSkills
import com.hoshii.lib.localdb.GetAllTasks

@JvmName("toDataModelGetAllRecurringTasks")
internal fun List<GetAllRecurringTasks>.toDataModel() = map { it.toDataModel() }
internal fun GetAllRecurringTasks.toDataModel() = RecurringTask(
    id = id,
    type = type,
    title = title,
    description = description,
    calculateProgressFromChildren = calculateProgressFromChildren,
    progress = progress,
    priority = priority,
    childrenIds = childrenIds,
    parents = parents,
    dateCreated = dateCreated,
    dateFinished = dateFinished,
    dateTodo = dateTodo,
    timeOfStart = timeOfStart,
    timeOfFinish = timeOfFinish,
    monetaryCost = monetaryCost,
    physicalEnergyCost = physicalEnergyCost,
    mentalEnergyCost = mentalEnergyCost,
    recurrenceType = recurrenceType,
    daysInterval = daysInterval,
    weekDays = weekDays,
    daysOfMonth = daysOfMonth,
    manualProgress = manualProgress,
)

@JvmName("toDataModelGetAllTasks")
internal fun List<GetAllTasks>.toDataModel() = map { it.toDataModel() }
internal fun GetAllTasks.toDataModel() = SimpleTask(
    id = id,
    type = type,
    title = title,
    description = description,
    calculateProgressFromChildren = calculateProgressFromChildren,
    progress = progress,
    priority = priority,
    childrenIds = childrenIds,
    parents = parents,
    dateCreated = dateCreated,
    dateFinished = dateFinished,
    dateTodo = dateTodo,
    timeOfStart = timeOfStart,
    timeOfFinish = timeOfFinish,
    monetaryCost = monetaryCost,
    physicalEnergyCost = physicalEnergyCost,
    mentalEnergyCost = mentalEnergyCost,
)

@JvmName("toDataModelGetAllSkills")
internal fun List<GetAllSkills>.toDataModel() = map { it.toDataModel() }
internal fun GetAllSkills.toDataModel() = Skill(
    id = id,
    type = type,
    title = title,
    description = description,
    calculateProgressFromChildren = calculateProgressFromChildren,
    progress = progress,
    priority = priority,
    childrenIds = childrenIds,
    parents = parents,
    dateCreated = dateCreated,
    dateFinished = dateFinished,
    dateOfStart = dateOfStart,
    dateOfFinish = dateOfFinish,
    skillLevel = level,
)

@JvmName("toDataModelGetAllGoals")
internal fun List<GetAllGoals>.toDataModel() = map { it.toDataModel() }
internal fun GetAllGoals.toDataModel() = SimpleGoal(
    id = id,
    type = type,
    title = title,
    description = description,
    calculateProgressFromChildren = calculateProgressFromChildren,
    progress = progress,
    priority = priority,
    childrenIds = childrenIds,
    parents = parents,
    dateCreated = dateCreated,
    dateFinished = dateFinished,
    dateOfStart = dateOfStart,
    dateOfFinish = dateOfFinish,
)

@JvmName("toDataModelEntryEntity")
internal fun List<EntryEntity>.toDataModel() = map { it.toDataModel() }
internal fun EntryEntity.toDataModel() = Folder(
    id = id,
    type = type,
    title = title,
    description = description,
    calculateProgressFromChildren = calculateProgressFromChildren,
    progress = progress,
    priority = priority,
    childrenIds = childrenIds,
    parents = parents,
    dateCreated = dateCreated,
    dateFinished = dateFinished,
)