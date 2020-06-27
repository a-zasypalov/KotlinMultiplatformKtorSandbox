package com.gaoyun.ktormpp.photo_service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url

class PhotoApi {
    private val client = HttpClient()

    private var address = Url("https://picsum.photos/v2/list")

    suspend fun getPhoto(): String {
        return client.get {
            url(address.toString())
        }
    }
}