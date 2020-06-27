package date

//Model-класс для MVP
data class DateState(var dateText: String)

//View-интерфейс для MVP
interface DateView {
    fun showDate(date: String)
}

//Presenter-класс для MVP
class DatePresenter(private val view: DateView) {

    private val state by lazy { DateState(dateUtilities.platformDate.getCurrentDate()) }

    fun init() {
        view.showDate(state.dateText)
    }

}

