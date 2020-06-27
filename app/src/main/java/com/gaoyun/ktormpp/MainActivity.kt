package com.gaoyun.ktormpp

import androidx.appcompat.app.AppCompatActivity
import com.gaoyun.ktormpp.date.DatePresenter
import com.gaoyun.ktormpp.date.DateView
import com.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main),
    DateView {

    private val presenter by lazy { DatePresenter(this) }

    override fun onStart() {
        super.onStart()
        presenter.init()
    }

    override fun showDate(date: String) {
        main_text.text = date
    }
}