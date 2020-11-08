package ca.six.kjdemo.rxjava

import io.reactivex.Observable

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
//=> szw : log(access api one)
//=> szw : log(access api two)



fun main() {
    accessMultiApi()
}