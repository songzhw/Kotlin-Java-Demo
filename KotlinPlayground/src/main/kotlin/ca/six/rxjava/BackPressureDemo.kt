package ca.six.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.interval(1, TimeUnit.MILLISECONDS, Schedulers.trampoline())
            .subscribe{
                Thread.sleep(1200)
                println("subscribe($it)")
            }
}