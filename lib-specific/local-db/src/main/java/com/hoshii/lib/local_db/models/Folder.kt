package com.hoshii.lib.local_db.models

data class Folder(
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
) : Entry