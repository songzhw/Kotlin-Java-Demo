package rxjava2

import io.reactivex.Observable

// scan和reduce都是把上一次操作的结果做为参数传递给第二次Observable使用
// 区别就在subscribe()是否被频繁调用. 见下面日志即知

fun main() {
    Observable.range(0, 6)
        .scan(12) { a, b ->
            println("    szw a = $a, b = $b")
            a + b
        }
        .subscribe { println("    $it") }

    Observable.range(0, 6)
        .reduce(12) { a, b ->
            println("==> a = $a, b = $b")
            a + b
        }
        .subscribe { v -> println("==> ${v}") }
}

/*
result:

    12
    szw a = 12, b = 0
    12
    szw a = 12, b = 1
    13
    szw a = 13, b = 2
    15
    szw a = 15, b = 3
    18
    szw a = 18, b = 4
    22
    szw a = 22, b = 5
    27

==> a = 12, b = 0
==> a = 12, b = 1
==> a = 13, b = 2
==> a = 15, b = 3
==> a = 18, b = 4
==> a = 22, b = 5
==> 27

 */