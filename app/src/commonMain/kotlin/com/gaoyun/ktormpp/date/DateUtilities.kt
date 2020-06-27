package com.gaoyun.ktormpp.date

//Функция для получения текущей форматированной даты
expect class PlatformDate() {
    fun getCurrentDate(): String
}

//Клас-утилита для хранения формата и точки обращения к функции получения даты
class DateUtilities {
    var platformDate = PlatformDate()
    val dateFormat = "dd-MM-YYYY HH:mm"
}

//Утилита получения даты для конкретной платформы
val dateUtilities = DateUtilities()