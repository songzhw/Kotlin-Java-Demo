package rxjava2.observables

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun cold_interval() {
    val cold = Observable.interval(1000, TimeUnit.MILLISECONDS)

    cold.subscribe { println("first $it") }

    Thread.sleep(2500)
    cold.subscribe{ println("second $it")}
}

fun code2hot(){
    val connectable = Observable.just("test")
            .publish()
    connectable.connect()

    connectable.subscribe { println("first $it") }

    connectable.subscribe{ println("second $it")}
}


fun main(args: Array<String>) {
    code2hot()
}