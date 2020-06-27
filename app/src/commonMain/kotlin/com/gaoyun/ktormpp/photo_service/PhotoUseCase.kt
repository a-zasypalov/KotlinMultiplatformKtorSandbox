package com.gaoyun.ktormpp.photo_service

class PhotoUseCase (private val repository: PhotoRepository) {

    suspend fun getPhotos(): List<PhotoResponse> = repository.getPhotos()

}