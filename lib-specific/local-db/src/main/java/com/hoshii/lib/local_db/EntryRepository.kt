package com.hoshii.lib.local_db

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.hoshii.lib.local_db.models.Entry
import com.hoshii.lib.local_db.models.Folder
import com.hoshii.lib.local_db.models.Goal
import com.hoshii.lib.local_db.models.RecurringTask
import com.hoshii.lib.local_db.models.SimpleGoal
import com.hoshii.lib.local_db.models.SimpleTask
import com.hoshii.lib.local_db.models.Skill
import com.hoshii.lib.local_db.models.Task
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
    /** Folder */
    fun addFolder(entry: Folder)
    fun updateFolder(entry: Folder)
    /** Task */
    fun addSimpleTask(entry: SimpleTask)
    fun updateSimpleTask(entry: SimpleTask)
    /** Recurring Task */
    fun addRecurringTask(entry: RecurringTask)
    fun updateRecurringTask(entry: RecurringTask)
    /** Goal */
    fun addSimpleGoal(entry: SimpleGoal)
    fun updateSimpleGoal(entry: SimpleGoal)
    /** Skill */
    fun addSkill(entry: Skill)
    fun updateSkill(entry: Skill)
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

    /** Entry */

    private fun addEntry(entry: Entry) {
        entryQueries.addEntry(
            type = entry.type,
            title = entry.title,
            description = entry.description,
            calculateProgressFromChildren = entry.calculateProgressFromChildren,
            progress = entry.progress,
            priority = entry.priority,
            childrenIds = entry.childrenIds,
            parents = entry.parents,
            dateCreated = entry.dateCreated,
            dateFinished = entry.dateFinished,
        )
    }

    private fun updateEntry(entry: Entry) {
        entryQueries.updateEntryById(
            id = entry.id,
            type = entry.type,
            title = entry.title,
            description = entry.description,
            calculateProgressFromChildren = entry.calculateProgressFromChildren,
            progress = entry.progress,
            priority = entry.priority,
            childrenIds = entry.childrenIds,
            parents = entry.parents,
            dateCreated = entry.dateCreated,
            dateFinished = entry.dateFinished,
        )
    }

    override fun remove(id: Long) {
        entryQueries.removeEntryById(id)
    }

    /** Folder */

    override fun addFolder(entry: Folder) {
        addEntry(entry)
    }

    override fun updateFolder(entry: Folder) {
        updateEntry(entry)
    }

    /** Task */

    private fun addTask(entry: Task) {
        taskQueries.addTask(
            timeOfStart = entry.timeOfStart,
            timeOfFinish = entry.timeOfFinish,
            dateTodo = entry.dateTodo,
            monetaryCost = entry.monetaryCost,
            physicalEnergyCost = entry.physicalEnergyCost,
            mentalEnergyCost = entry.mentalEnergyCost,
        )
    }

    override fun addSimpleTask(entry: SimpleTask) {
        taskQueries.transaction {
            addEntry(entry)
            addTask(entry)
        }
    }

    private fun updateTask(id: Long, entry: Task) {
        taskQueries.updateTaskById(
            id = id,
            timeOfStart = entry.timeOfStart,
            timeOfFinish = entry.timeOfFinish,
            dateTodo = entry.dateTodo,
            monetaryCost = entry.monetaryCost,
            physicalEnergyCost = entry.physicalEnergyCost,
            mentalEnergyCost = entry.mentalEnergyCost,
        )
    }

    override fun updateSimpleTask(entry: SimpleTask) {
        taskQueries.transaction {
            updateEntry(entry)
            updateTask(entry.id, entry)
        }
    }

    /** Recurring Task */

    override fun addRecurringTask(entry: RecurringTask) {
        recurringQueries.transaction {
            addEntry(entry)
            addTask(entry)
            recurringQueries.addRecurring(
                recurrenceType = entry.recurrenceType,
                daysInterval = entry.daysInterval,
                weekDays = entry.weekDays,
                daysOfMonth = entry.daysOfMonth,
                manualProgress = entry.manualProgress,
            )
        }
    }

    override fun updateRecurringTask(entry: RecurringTask) {
        recurringQueries.transaction {
            updateEntry(entry)
            updateTask(entry.id, entry)
            recurringQueries.updateRecurringById(
                id = entry.id,
                recurrenceType = entry.recurrenceType,
                daysInterval = entry.daysInterval,
                weekDays = entry.weekDays,
                daysOfMonth = entry.daysOfMonth,
                manualProgress = entry.manualProgress,
            )
        }
    }

    /** Goal */

    private fun addGoal(entry: Goal) {
        goalQueries.addGoal(
            dateOfStart = entry.dateOfStart,
            dateOfFinish = entry.dateOfFinish,
        )
    }

    override fun addSimpleGoal(entry: SimpleGoal) {
        goalQueries.transaction {
            addEntry(entry)
            addGoal(entry)
        }
    }

    private fun updateGoal(id: Long, entry: Goal) {
        goalQueries.updateGoalById(
            id = id,
            dateOfStart = entry.dateOfStart,
            dateOfFinish = entry.dateOfFinish,
        )
    }

    override fun updateSimpleGoal(entry: SimpleGoal) {
        goalQueries.transaction {
            updateEntry(entry)
            updateGoal(entry.id, entry)
        }
    }

    /** Skill */

    override fun addSkill(entry: Skill) {
        skillQueries.transaction {
            addEntry(entry)
            addGoal(entry)
            skillQueries.addSkill(
                level = entry.skillLevel,
            )
        }
    }

    override fun updateSkill(entry: Skill) {
        skillQueries.transaction {
            updateEntry(entry)
            updateGoal(entry.id, entry)
            skillQueries.updateSkillById(
                id = entry.id,
                level = entry.skillLevel,
            )
        }
    }

    init {
        coroutineScope.launch {

        }
    }
}