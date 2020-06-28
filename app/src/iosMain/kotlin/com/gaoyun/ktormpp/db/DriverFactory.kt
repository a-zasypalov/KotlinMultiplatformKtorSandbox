package com.gaoyun.ktormpp.db

import com.gaoyun.ktormpp.Database
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(Database.Schema, "photos.db")

}