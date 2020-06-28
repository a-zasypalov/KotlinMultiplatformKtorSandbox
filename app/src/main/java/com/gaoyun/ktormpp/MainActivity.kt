package com.gaoyun.ktormpp

import androidx.appcompat.app.AppCompatActivity
import com.gaoyun.ktormpp.date.DatePresenter
import com.gaoyun.ktormpp.date.DateView
import com.R
import com.bumptech.glide.Glide
import com.gaoyun.ktormpp.db.DriverFactory
import com.gaoyun.ktormpp.photo_service.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main),
    DateView, PhotoView {

    private val photoPresenter by lazy {
        PhotoPresenter(PhotoUseCase(
            PhotoRepository(PhotoApi()),
            DriverFactory(this@MainActivity)
        ),this)
    }
    private val datePresenter by lazy { DatePresenter(this) }

    override fun onStart() {
        super.onStart()

        datePresenter.init()

        btn_fst_db.setOnClickListener { photoPresenter.getPhotoFromDb() }
        btn_snd_db.setOnClickListener { photoPresenter.getNewPhotoFromDb() }
        btn_from_api.setOnClickListener { photoPresenter.getRandomPhoto() }
    }

    override fun showDate(date: String) {
        tv_time.text = date
    }

    override fun setPhoto(photo: PhotoState) {
        tv_photo_info.text = photo.list.first().author

        Glide.with(this)
            .load(photo.list.first().download_url)
            .centerCrop()
            .into(img_photo)
    }
}