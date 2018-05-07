package ca.six.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    /*
    Nothing hapens

    Observable.interval(1, TimeUnit.SECONDS)
            .subscribe { println("$it") }

    */

    /*
    Solution 01

    Observable.interval(1, TimeUnit.SECONDS)
        .subscribe {
            println("$it ${Thread.currentThread().name}")
        }

    Thread.sleep(2000)

     */


    // =================== 1. interval 坑 ===================
    Observable.interval(1500, TimeUnit.MILLISECONDS, Schedulers.trampoline())
            .subscribe { println("$it ${Thread.currentThread().name}") } //=> 0 main; 1 main; ...

    // Schdulers.immediate() is okay too, just not recommended for this type of work(interval)


}