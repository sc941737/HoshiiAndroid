package com.hoshii.lib.local_db.models

import kotlinx.serialization.Serializable
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

const val DONE = 100
const val ZERO = 0

interface Entry {
    val id: Long
    val type: EntryType
    val title: String?
    val description: String?
    val calculateProgressFromChildren: Boolean
    val progress: Int
    val priority: Int
    val childrenIds: List<Long>?
    val parents: List<Parent>?
    val dateCreated: Long
    val dateFinished: Long?

    fun isDone(): Boolean = progress == DONE

    fun isEqualTo(otherEntry: Entry): Boolean = with (this) {
        title == otherEntry.title
                && description == otherEntry.description
                && calculateProgressFromChildren == otherEntry.calculateProgressFromChildren
                && progress == otherEntry.progress
                && priority == otherEntry.priority
                && childrenIds == otherEntry.childrenIds
                && parents == otherEntry.parents
                && dateCreated == otherEntry.dateCreated
                && dateFinished == otherEntry.dateFinished
    }

    fun getIndexInParent(parentId: Long): Int =
        parents?.find { id == parentId }?.childIndex ?: throw Exception("Found an orphan: parentId: $parentId")
}

enum class EntryType {
    FOLDER, TASK, RECURRING_TASK, GOAL, SKILL, EVENT
}

@Serializable
data class Parent(
    val id: Long,
    val childIndex: Int
)