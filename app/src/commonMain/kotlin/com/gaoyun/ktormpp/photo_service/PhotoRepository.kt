package com.gaoyun.ktormpp.photo_service

class PhotoRepository (private val api: PhotoApi) {

    suspend fun getPhoto(): String = api.getPhoto()

}