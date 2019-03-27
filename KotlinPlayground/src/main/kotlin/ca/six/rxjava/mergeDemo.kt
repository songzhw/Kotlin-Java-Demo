package ca.six.rxjava

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import java.text.SimpleDateFormat


fun main(args: Array<String>) {
    // 数据会从0开始, 数据是每N秒0,1,2,3,...
    val one = Observable.interval(3, TimeUnit.SECONDS)
    val two = Observable.interval(2, TimeUnit.SECONDS)

    two
        .withLatestFrom(one, object : BiFunction<Long, Long, String> {
            @Throws(Exception::class)
            override fun apply(num1: Long, num2: Long): String {
                val sdf = SimpleDateFormat("hh:mm:ss")
                return "$num1, $num2 - ${sdf.format(Date())}"
            }
        })
        .subscribe { str -> println("szw output = $str") }
}