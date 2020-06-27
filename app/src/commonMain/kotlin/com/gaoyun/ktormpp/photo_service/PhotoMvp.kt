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

    private val state = PhotoState("")

    fun getRandomPhoto() {
        GlobalScope.apply {
            launch(Background) {
               state.info = useCase.getPhoto()
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
    var info: String
)
