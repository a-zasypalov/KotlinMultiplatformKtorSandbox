package com.gaoyun.ktormpp.db

import android.content.Context
import com.gaoyun.ktormpp.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(Database.Schema, context, "photos.db")

}