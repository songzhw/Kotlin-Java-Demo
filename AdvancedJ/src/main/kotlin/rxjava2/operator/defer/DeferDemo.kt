package rxjava2.operator.defer

import io.reactivex.Observable
import java.io.IOException



class Dog(var name: String) {
    fun observe(): Observable<String> {
        return Observable.just(name)
    }
}

fun justDemo() {
    val dog = Dog("one")

    val observable = dog.observe()

    dog.name = "two"

    observable.subscribe { println("dog name = $it") } //=> one

}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

/*
defer(callable) : 在发生订阅关系时，callable.call();
 */
class Corgi(var name: String) {
    fun observe(): Observable<String> {
        // defer参数是一个Callable, 其实是public interface Callable<V> {    V call() ;   }
        // defer的这个Callable限定死了得返回一个Observable<T>
        return Observable.defer {
            Observable.just(name)
        }
    }
}

fun deferDemo() {
    val dog = Corgi("one")

    val observable = dog.observe()

    dog.name = "two"

    observable.subscribe { println("Corgi name = $it") } //=> two

}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

class ShibaInu(var name: String) {
    fun observe(): Observable<String> {
        return Observable.create { emitter ->
            emitter.onNext(name)
            emitter.onComplete()
        }
    }
}

fun createDemo() {
    val dog = ShibaInu("one")

    val observable = dog.observe()

    dog.name = "two"

    observable.subscribe { println("ShibaInu name = $it") } //=> two

}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
// 一个更真实的例子: 只有真正订阅了时, 才去存数据
object db {
    fun <T> writeToDisk(t: T) {}
    fun close() {}
}

fun saveData(valueToSave: String): Observable<String> {
    return Observable.defer {
        try {
            db.writeToDisk(valueToSave)
        } catch (e: Exception) {
            Observable.error<String>(e)
        } finally {
            db.close()
        }
        Observable.just(valueToSave)
    }
}



// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
fun main(args: Array<String>) {
    println(" - - - - - - - - - - - - ")
    justDemo()
    println(" - - - - - - - - - - - - ")
    deferDemo()
    println(" - - - - - - - - - - - - ")
    createDemo()
    println(" - - - - - - - - - - - - ")
}