package ca.six.kjdemo

import io.reactivex.Observable

fun main() {
    Observable.range(1, 8)
        .groupBy { num -> if (num % 2 == 0) "even" else "odd" }
        .filter{pair -> pair.key == "odd"}
        .subscribe{ob -> ob.subscribe{pair -> println(pair)}}
}

