package com.hoshii.lib.local_db.adapters

import app.cash.sqldelight.ColumnAdapter
import com.hoshii.lib.local_db.models.Parent
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class ParentListAdapter : ColumnAdapter<List<Parent>, String> {
    override fun decode(databaseValue: String): List<Parent> =
        Json.decodeFromString<ParentListWrapper>(databaseValue).parents

    override fun encode(value: List<Parent>): String =
        Json.encodeToString(ParentListWrapper(value))
}

@Serializable
internal data class ParentListWrapper(
    val parents: List<Parent>
)