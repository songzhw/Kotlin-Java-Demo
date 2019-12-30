package rxjava2

import io.reactivex.Observable

fun main() {
    Observable.range(0, 6)
        .scanWith({ 10 }, { t1, t2 -> t1 + t2 })
        .subscribe {
            println("___ result = ${it}")
        }

    Observable.range(0, 6)
        .reduceWith({ 10 }, { t1, t2 -> t1 + t2 })
        .subscribe { v ->
            println("|| result = ${v}")
        }
}

/*
___ result = 10
___ result = 10
___ result = 11
___ result = 13
___ result = 16
___ result = 20
___ result = 25

|| result = 25
 */