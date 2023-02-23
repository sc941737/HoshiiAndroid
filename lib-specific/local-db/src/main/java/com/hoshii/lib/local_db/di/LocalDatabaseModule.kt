package com.hoshii.lib.local_db.di

import com.hoshii.lib.local_db.Database
import com.hoshii.lib.local_db.EntryRepository
import com.hoshii.lib.local_db.EntryRepositoryImpl
import org.koin.dsl.module

val localDbModule = module {
    includes(localDbQueriesModule)
    single {
        Database(
            driver = get(),
            EntryEntityAdapter = get(),
            RecurringEntityAdapter = get(),
            TaskEntityAdapter = get(),
            SkillEntityAdapter = get(),
        )
    }
    single<EntryRepository> {
        EntryRepositoryImpl(
            coroutineScope = get(),
            entryQueries = get(),
            goalQueries = get(),
            skillQueries = get(),
            taskQueries = get(),
            recurringQueries = get(),
        )
    }
}