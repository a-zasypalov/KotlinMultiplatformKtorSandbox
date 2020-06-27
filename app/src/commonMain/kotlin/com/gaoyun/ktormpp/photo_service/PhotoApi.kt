package com.gaoyun.ktormpp.photo_service

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class PhotoApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer =
                KotlinxSerializer(Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = true)))
        }
    }

    private var address = Url("https://picsum.photos/v2/list")

    suspend fun getPhoto(): List<PhotoResponse> {
        return client.get {
            url(address.toString())
        }
    }
}

@Serializable
data class PhotoResponse(
    val id: Int?,
    val author: String?,
    val url: String?,
    val download_url: String?
)