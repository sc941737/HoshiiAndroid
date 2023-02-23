package com.hoshii.lib.local_db.di

import com.hoshii.lib.localdb.EntryEntityQueries
import com.hoshii.lib.localdb.GoalEntityQueries
import com.hoshii.lib.localdb.RecurringEntityQueries
import com.hoshii.lib.localdb.SkillEntityQueries
import com.hoshii.lib.localdb.TaskEntityQueries
import org.koin.dsl.module

internal val localDbQueriesModule = module {
    includes(localDbAdaptersModule)
    single { EntryEntityQueries(
        driver = get(),
        EntryEntityAdapter = get(),
    ) }
    single { GoalEntityQueries(
        driver = get(),
        EntryEntityAdapter = get(),
    ) }
    single { TaskEntityQueries(
        driver = get(),
        TaskEntityAdapter = get(),
        EntryEntityAdapter = get(),
    ) }
    single { RecurringEntityQueries(
        driver = get(),
        RecurringEntityAdapter = get(),
        EntryEntityAdapter = get(),
        TaskEntityAdapter = get(),
    ) }
    single { SkillEntityQueries(
        driver = get(),
        EntryEntityAdapter = get(),
        SkillEntityAdapter = get(),
    ) }
}