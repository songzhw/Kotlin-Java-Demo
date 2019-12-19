package rxjava2.operator.time

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

}

fun delay_(args: Array<String>) {
    Observable.just("first data")
            .delay(4, TimeUnit.SECONDS, Schedulers.trampoline())
            .subscribe { println("subscribe $it") }
    // 4秒后才收到"subscribe first data"
}

fun interval_(args: Array<String>) {
    Observable.interval(2, TimeUnit.SECONDS, Schedulers.trampoline())
            .flatMap {
                println("flatMap $it")
                Observable.just("item")
            }
            .subscribe { println("subscribe : $it") }
}

fun timer_() {
    Observable.timer(3, TimeUnit.SECONDS, Schedulers.trampoline())
            .flatMap {
                println("flatMap  $it")
                Observable.just("timer()")
            }
            .subscribe { println("subscribe $it") }
    // 先停三秒. 三秒之后打印出:  flatMap  0  ;  subscribe timer()
}