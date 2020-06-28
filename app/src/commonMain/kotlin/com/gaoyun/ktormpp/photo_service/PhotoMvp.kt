package com.gaoyun.ktormpp.photo_service

import com.gaoyun.ktormpp.Background
import com.gaoyun.ktormpp.Main
import com.gaoyun.ktormpp.data.PhotoEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.single
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

    fun getPhotoFromDb() {
        GlobalScope.apply {
            launch(Background) {
                state.list = mutableListOf(useCase.getFirstPhotoFromDb().toPhoto())
                withContext(Main) {
                    view.setPhoto(state)
                }
            }
        }
    }

    fun getNewPhotoFromDb() {
        GlobalScope.apply {
            launch(Background) {
                state.list = mutableListOf(useCase.getLastPhotoFromDb().toPhoto())
                withContext(Main) {
                    view.setPhoto(state)
                }
            }
        }
    }

}

interface PhotoView {
    fun setPhoto(photo: PhotoState)
}

//State holder
data class PhotoState(
    var list: MutableList<Photo>
)

//Photo UI model
data class Photo(
    val id: Int,
    val author: String,
    val url: String,
    val download_url: String
)


//Mapper extensions
fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        this.id.toInt(),
        this.author ?: "",
        "",
        this.url
    )
}

fun PhotoResponse.toPhoto(): Photo {
    return Photo(
        this.id ?: -1,
        this.author ?: "",
        this.url ?: "",
        this.download_url ?: ""
    )
}
