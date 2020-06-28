package com.gaoyun.ktormpp.photo_service

import com.gaoyun.ktormpp.data.PhotoEntity
import com.gaoyun.ktormpp.db.DriverFactory
import com.gaoyun.ktormpp.db.getNewPhotosFromDb
import com.gaoyun.ktormpp.db.getPhotosFromDb
import kotlinx.coroutines.flow.Flow

class PhotoUseCase (private val repository: PhotoRepository, private val dbDriver: DriverFactory) {

    suspend fun getPhotos(): List<PhotoResponse> = repository.getPhotos()

    fun getFirstPhotoFromDb(): PhotoEntity = getPhotosFromDb(dbDriver)
    fun getLastPhotoFromDb(): PhotoEntity = getNewPhotosFromDb(dbDriver)

}