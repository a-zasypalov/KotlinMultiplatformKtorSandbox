package com.gaoyun.ktormpp.photo_service

class PhotoUseCase (private val repository: PhotoRepository) {

    suspend fun getPhoto(): String = repository.getPhoto()

}