package com.example.utils

import java.text.SimpleDateFormat
import java.util.Date

class DatetimeUtil(
    private var format: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
) {
    fun longToDate(time: Long): String {
        val date = Date(time)
        return this.format.format(date)
    }

    fun dateToLong(date: String): Long {
        return this.format.parse(date).time
    }

    fun currentDatetimeToString(): String {
        return this.longToDate(System.currentTimeMillis())
    }

    fun currentDatetimeToLong(): Long {
        return System.currentTimeMillis()
    }
}