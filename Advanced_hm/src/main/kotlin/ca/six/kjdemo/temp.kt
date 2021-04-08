package ca.six.kjdemo

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    Observable.interval(10, TimeUnit.MICROSECONDS)
        .subscribe{num -> println(num)}
}


fun groupBy_Demo() {
    // groupBy()得到的是一个 GroupedObservable(), 所以才要后面再用flatMap()
    Observable.range(1, 8)
        .groupBy { num -> if (num % 2 == 0) "even" else "odd" }
        .filter { groupOb -> groupOb.key == "odd" }
        .flatMap { it -> it }
        .subscribe { num -> println(num) }
}
