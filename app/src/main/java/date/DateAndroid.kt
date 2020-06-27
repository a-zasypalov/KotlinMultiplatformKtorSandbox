package date

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

actual class PlatformDate {
    actual fun getCurrentDate(): String {
        val date = Calendar.getInstance().time
        val df = SimpleDateFormat(dateUtilities.dateFormat, Locale.getDefault())
        return df.format(date)
    }
}

class MainActivity : AppCompatActivity(), DateView {

    private val presenter by lazy { DatePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.init()
    }

    override fun showDate(date: String) {
        main_text.text = date
    }
}