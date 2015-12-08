package cn.six.rxtest.observ

import rx.Observable
import java.util.*

/**
 * Created by hzsongzhengwang on 2015/12/4.
 */

var api1 = Observable.create<String> {
    try {
        Thread.sleep(2000);
    } catch(e: Exception) {
    }
    it.onNext("access api one")
}

var api2 = Observable.create<String> {
    try {
        Thread.sleep(1000);
    } catch(e: Exception) {
    }
    it.onNext("access api two")
}

fun accessMultiApi() {
    var d = Date();
    println("${d.minutes}:${d.seconds}  accessMultiApi()")
    Observable
            .merge(api1, api2)
            .subscribe {
                d = Date()
                println("${d.minutes}:${d.seconds} szw : trace -- accessMultiApi(${it})")
            }
}

fun main(args: Array<String>) {
    accessMultiApi()
}


/*
[result]

40:39  accessMultiApi()
40:41 szw : trace -- accessMultiApi(access api one)
40:42 szw : trace -- accessMultiApi(access api two)

 */