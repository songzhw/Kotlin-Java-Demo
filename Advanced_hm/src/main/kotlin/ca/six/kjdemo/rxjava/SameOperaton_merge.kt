package ca.six.kjdemo.rxjava

import ca.six.kjdemo.utils.now
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.*

var api1 = Observable.create<String> {
    Thread.sleep(2000);
    it.onNext("access api one")
}
var api2 = Observable.create<String> {
    Thread.sleep(1000);
    it.onNext("access api two")
}

fun accessMultiApi() {
    Observable.merge(api1, api2)
        .subscribe { println("szw : log(${it})") }
}
// 20:00:25:950
//=> szw : log(access api one)
//=> szw : log(access api two)
// 20:00:29:027  (耗时3秒, 不是2秒! 而且是先出1, 再出2, 可见是同步!!) (同步是因为都是在UI主线程上, 并都sleep了)

fun accessMultiApi2() {
    Observable.zip(api1, api2,
        BiFunction<String, String, String> { s1, s2 -> "[$s1, $s2]" })
        .subscribe { println("szw : log(${it})") }
}


fun main() {
    println("merge start: ${now()}")
    accessMultiApi()
    println("merge end: ${now()}")


    Thread.sleep(1000)
    println("zip start: ${now()}")
    accessMultiApi2()
    println("zip end: ${now()}")
}
// 20:00:30:033
//=> szw : log([access api one, access api two])
//=> 20:00:33:043 (也是要全部执行完, 也是同步的, 也是耗时3秒) (同步是因为都是在UI主线程上, 并都sleep了)