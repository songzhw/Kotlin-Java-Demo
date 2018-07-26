package rxjava2

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe

/*
RxJava2中为了区分背压的支持, 分出了Observable 与 Flowable.
另外, 除此以外, RxJava2还有三种新类型的事件源: Single, Completable, Maybe.
 */

fun isLogin() : Boolean{
    val random : Int = (Math.random()*100).toInt()
    println("random = $random")
    return random %2 == 0
}

fun main(args: Array<String>) {
    // =================== Maybe ===================
    // Maybe: 发送0或1个数据. 要么成功, 要么失败. 没有onNext(), 用onSuccess()发送数据
    Maybe.just(isLogin())
            .subscribe({ isLogin ->
                println("maybe : $isLogin")
            })

    // =================== Single ===================
    // Single: 只发送单个数据/事件. 所以只有onSuccess(), onError()事件, 没有onComplete()事件
    val single = Single.create(SingleOnSubscribe<String> { emitter ->
        emitter.onSuccess("OneEvent")
    })
    single.subscribe { str -> println("single $str")}



    // =================== Completable ===================
    // Completable: 从不发送数据, 只处理onComplete, onError事件. 没有onNext(), onSuccess()事件
    // 多与andThen()配合起来用. 比如说Model中取数据, 返回一个Completable表示做完/出错了(不传数据时), presenter中用andThen()来让view工作
    Completable.create { emitter -> emitter.onComplete() }
            .andThen(Flowable.range(1, 10))
            .subscribe{
                println("completable $it")
            }
}