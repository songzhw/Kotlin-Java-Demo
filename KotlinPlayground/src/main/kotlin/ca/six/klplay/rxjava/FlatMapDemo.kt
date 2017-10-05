package ca.six.kplay.rxjava

import io.reactivex.Observable

fun demo1() {
    Observable.just(1, 2, 3)
            .flatMap {
                if (it % 2 == 0) {
                    Observable.error(RuntimeException("even number"))
                } else {
                    Observable.just("szw $it")
                }
            }
            .subscribe(
                    { println("next = ${it.substring(0)}") },
                    { println("error = $it") }
            )

    // 1. 没有flatMap()时。正常打印， 结果分别是： next = 1，next = 2，next = 3， 一共走三次
    // 2. 有flatMap()后， 结果分别是： next = 1, error = RuntimeException。 "3"的结果就不走了！
}

// 写成Observable.onError<Exception>(exp), 那subscribe中第一参Consumer onNext就会不知道it的类型是什么！
fun demo2() {
    val ob = Observable.create<String> { emitter ->
        emitter.onNext("Test")
    }

    ob.flatMap {
            if (it.length > 2) {
                Observable.error(RuntimeException("too long"))
            } else {
                Observable.just("szw $it")
            }
        }
        .subscribe(
                { println("next = ${it.substring(0)}") },
                { println("error = $it") }
        )

}

fun main(args: Array<String>) {
    demo2()
}
