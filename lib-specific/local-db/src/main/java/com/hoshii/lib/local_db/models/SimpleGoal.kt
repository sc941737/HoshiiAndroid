package com.hoshii.lib.local_db.models

data class SimpleGoal(
    /** Entry fields **/
    override val id: Long,
    override val type: EntryType,
    override val title: String?,
    override val description: String?,
    override val calculateProgressFromChildren: Boolean,
    override val progress: Int,
    override val priority: Int,
    override val childrenIds: List<Long>?,
    override val parents: List<Parent>?,
    override val dateCreated: Long,
    override val dateFinished: Long?,
    /** Goal fields **/
    override val dateOfStart: Long?,
    override val dateOfFinish: Long?,
    //todo create a warning field above/below "setting a deadline is good etc." and set visibility to whether dateOfFinish is filled
) : Entry, Goal