package rxjava2.operator.defer

import io.reactivex.Observable

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

class Corgi(var name: String){
    fun observe() : Observable<String> {
        // defer参数是一个Callable, 其实是public interface Callable<V> {    V call() ;   }
        // defer的这个Callable限定死了得返回一个Observable<T>
        return Observable.defer {
            Observable.just(name)
        }
    }
}

fun deferDemo(){
    val dog = Corgi("one")

    val observable = dog.observe()

    dog.name = "two"

    observable.subscribe { println("dog name = $it") } //=> two
}

fun main(args: Array<String>) {
    deferDemo()
}