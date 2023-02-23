package com.hoshii.lib.local_db

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.hoshii.lib.local_db.models.Entry
import com.hoshii.lib.local_db.models.EntryType
import com.hoshii.lib.local_db.models.Folder
import com.hoshii.lib.localdb.EntryEntityQueries
import com.hoshii.lib.localdb.GoalEntityQueries
import com.hoshii.lib.localdb.RecurringEntityQueries
import com.hoshii.lib.localdb.SkillEntityQueries
import com.hoshii.lib.localdb.TaskEntityQueries
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

interface EntryRepository {
    val entries: Flow<List<Entry>>
    fun remove(id: Long)
    fun addGoal()
}

class EntryRepositoryImpl(
    private val entryQueries: EntryEntityQueries,
    private val goalQueries: GoalEntityQueries,
    private val skillQueries: SkillEntityQueries,
    private val taskQueries: TaskEntityQueries,
    private val recurringQueries: RecurringEntityQueries,
    private val coroutineScope: CoroutineScope,
) : EntryRepository {
    private fun <T : Any> Query<T>.toListFlow() = asFlow().flowOn(Dispatchers.IO).mapToList(Dispatchers.Default)

    private val skills = skillQueries.getAllSkills().toListFlow()
    private val goals = goalQueries.getAllGoals().toListFlow()
    private val recurringTasks = recurringQueries.getAllRecurringTasks().toListFlow()
    private val tasks = taskQueries.getAllTasks().toListFlow()
    private val folders = entryQueries.getAllFolders().toListFlow()

    override val entries: Flow<List<Entry>> = folders
        .combine(tasks) { foldersQuery, tasksQuery ->
            val folders = foldersQuery.toDataModel()
            val tasks = tasksQuery.toDataModel()
            folders.plus(tasks)
        }
        .combine(recurringTasks) { entries, recurringTasksQuery ->
            val recurringTasks = recurringTasksQuery.toDataModel()
            entries.plus(recurringTasks)
        }
        .combine(goals) { entries, goalsQuery ->
            val goals = goalsQuery.toDataModel()
            entries.plus(goals)
        }
        .combine(skills) { entries, skillsQuery ->
            val skills = skillsQuery.toDataModel()
            entries.plus(skills)
        }
        .flowOn(Dispatchers.Default)

    override fun addGoal() {
        goalQueries.transaction {
            entryQueries.addEntry(
                type = EntryType.GOAL,
                title = "quack",
                description = null,
                calculateProgressFromChildren = false,
                progress = 0,
                priority = 0,
                childrenIds = emptyList(),
                parents = emptyList(),
                dateCreated = 0,
                dateFinished = 0,
            )
            goalQueries.addGoal(
                dateOfStart = 0,
                dateOfFinish = 0,
            )
        }
    }

    override fun remove(id: Long) {
        entryQueries.removeEntryById(id)
    }

    init {
        coroutineScope.launch {

        }
    }
}