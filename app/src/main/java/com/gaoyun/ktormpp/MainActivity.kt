package com.gaoyun.ktormpp

import androidx.appcompat.app.AppCompatActivity
import com.gaoyun.ktormpp.date.DatePresenter
import com.gaoyun.ktormpp.date.DateView
import com.R
import com.gaoyun.ktormpp.photo_service.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main),
    DateView, PhotoView {

    private val photoPresenter by lazy { PhotoPresenter(PhotoUseCase(PhotoRepository(PhotoApi())),this) }
    private val datePresenter by lazy { DatePresenter(this) }

    override fun onStart() {
        super.onStart()

        photoPresenter.getRandomPhoto()
        datePresenter.init()
    }

    override fun showDate(date: String) {
        tv_time.text = date
    }

    override fun setPhoto(photo: PhotoState) {
        tv_photo_info.text = photo.info
    }
}