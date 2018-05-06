package ca.six.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

// =================== 2. 控制发送速度: 过滤 ===================
    Observable.interval(10, TimeUnit.MILLISECONDS, Schedulers.trampoline())
            .sample(200, TimeUnit.MILLISECONDS)
            .subscribe { println("$it ${Thread.currentThread().name}") } //=> 0 main; 1 main; ...
/*
只会播出19, 39, 58, 78, .... 这些事件. 其它事件都被抛弃了
这就是sample()的效果
 */




// =================== 3. 控制发送速度: 缓存===================
    Observable.interval(1, TimeUnit.MILLISECONDS, Schedulers.trampoline())
            .buffer(100, TimeUnit.MILLISECONDS)
            .subscribe { list ->
                Thread.sleep(1000)
                println("list.size = ${list.size}")
            }
/*
其实就是把100毫秒内的事件全打包成一个list发送出去
所以打印结果是: 100, 1003, 1006, 1004, ....
(先是100, 再以后每次都是1000左右)
 */
}