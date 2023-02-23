package com.hoshii.lib.local_db.models

data class Skill(
    /** Entry fields **/
    override val id: Long = -1,
    override val type: EntryType = EntryType.SKILL,
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
    /** Skill fields **/
    val skillLevel: Int,
) : Entry, Goal