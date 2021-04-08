package ca.six.kjdemo

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    var temp = 0L
    Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.trampoline())
        .filter{ num ->
            if(num - temp >= 20) {
                temp = num
                true
            } else {
                false
            }
        }
        .subscribe{num -> println(num)} //=> 20, 40, 60, 80, 100, 120, ...
}


fun groupBy_Demo() {
    // groupBy()得到的是一个 GroupedObservable(), 所以才要后面再用flatMap()
    Observable.range(1, 8)
        .groupBy { num -> if (num % 2 == 0) "even" else "odd" }
        .filter { groupOb -> groupOb.key == "odd" }
        .flatMap { it -> it }
        .subscribe { num -> println(num) }
}
