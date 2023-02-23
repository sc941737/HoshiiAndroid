package com.hoshii.lib.local_db.models

data class RecurringTask (
    /** Entry fields **/
    override val id: Long = -1,
    override val type: EntryType = EntryType.RECURRING_TASK,
    override val title: String?,
    override val description: String?,
    override val calculateProgressFromChildren: Boolean,
    override val progress: Int,
    override val priority: Int,
    override val childrenIds: List<Long>?,
    override val parents: List<Parent>?,
    override val dateCreated: Long,
    override val dateFinished: Long?,
    /** Task fields **/
    override val dateTodo: Long, // for recurring tasks this is the starting date
    override val timeOfStart: Int?,
    override val timeOfFinish: Int?,
    override val monetaryCost: Float,
    override val physicalEnergyCost: Energy,
    override val mentalEnergyCost: Energy,
    /** Recurring fields **/
    override val recurrenceType: RecurrenceType,
    override val daysInterval: Int,
    override val weekDays: List<WeekDay>,
    override val daysOfMonth: List<Int>,
    override val manualProgress: Boolean,
) : Entry, Task, Recurring