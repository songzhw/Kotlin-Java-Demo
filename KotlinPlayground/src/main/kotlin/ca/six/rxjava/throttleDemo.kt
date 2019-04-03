package ca.six.rxjava

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.interval(250, TimeUnit.MILLISECONDS)
            .subscribe{ v-> println(v)}
}