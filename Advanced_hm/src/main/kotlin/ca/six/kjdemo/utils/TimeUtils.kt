package ca.six.kjdemo.utils

import java.text.SimpleDateFormat
import java.util.*

fun now(): String {
    val ms = System.currentTimeMillis()
    val date = Date(ms)
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    return formatter.format(date)
}