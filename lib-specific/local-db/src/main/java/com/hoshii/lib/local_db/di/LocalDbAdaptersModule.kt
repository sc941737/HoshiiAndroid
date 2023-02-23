package com.hoshii.lib.local_db.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.hoshii.lib.local_db.Database
import com.hoshii.lib.local_db.adapters.entryEntityAdapter
import com.hoshii.lib.local_db.adapters.recurringEntityAdapter
import com.hoshii.lib.local_db.adapters.skillEntityAdapter
import com.hoshii.lib.local_db.adapters.taskEntityAdapter
import org.koin.dsl.module

internal val localDbAdaptersModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = Database.Schema,
            context = get(),
            name = "test2.db", //todo
        )
    }
    single { entryEntityAdapter }
    single { recurringEntityAdapter }
    single { taskEntityAdapter }
    single { skillEntityAdapter }
}