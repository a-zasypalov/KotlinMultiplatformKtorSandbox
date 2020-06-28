package com.gaoyun.ktormpp.db

import com.gaoyun.ktormpp.Database
import com.gaoyun.ktormpp.data.PhotoEntity
import com.gaoyun.ktormpp.data.PhotoQueries
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun getPhotosFromDb(driverFactory: DriverFactory): PhotoEntity {
    val driver = driverFactory.createDriver()
    val database = Database(driver)

    val photoQueries: PhotoQueries = database.photoQueries

    return photoQueries.selectAll().executeAsList().first()
}

fun getNewPhotosFromDb(driverFactory: DriverFactory): PhotoEntity {
    val driver = driverFactory.createDriver()
    val database = Database(driver)

    val photoQueries: PhotoQueries = database.photoQueries
    try {
        photoQueries.insertPhoto(117, "https://picsum.photos/id/117/1544/1024", "Daniel Ebersole")
    } catch (e: Exception){
        println(e.message)
    }

    return photoQueries.selectAll().executeAsList().last()
}