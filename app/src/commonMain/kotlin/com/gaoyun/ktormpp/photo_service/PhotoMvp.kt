package com.gaoyun.ktormpp.photo_service

import com.gaoyun.ktormpp.Background
import com.gaoyun.ktormpp.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoPresenter(
    private val useCase: PhotoUseCase,
    private val view: PhotoView
) {

    private val state = PhotoState(mutableListOf())

    fun getRandomPhoto() {
        GlobalScope.apply {
            launch(Background) {
               state.list = useCase.getPhotos().map { it.toPhoto() }.toMutableList()
                withContext(Main){
                    view.setPhoto(state)
                }
            }
        }
    }

}

interface PhotoView {
    fun setPhoto(photo: PhotoState)
}

data class PhotoState(
    var list: MutableList<Photo>
)

data class Photo(
    val id: Int,
    val author: String,
    val url: String,
    val download_url: String
)

fun PhotoResponse.toPhoto(): Photo {
    return Photo(
        this.id ?: -1,
        this.author ?: "",
        this.url ?: "",
        this.download_url ?: ""
    )
}
