package ca.six.kjdemo

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.util.regex.Pattern

val from = "Android&#24320;&#21457;&#33402;&#26415;&#25506;&#32034;.epub"

fun main() {
    var result = from
    val pattern = Pattern.compile("&#(\\d+);")
    val matches = pattern.matcher(from)
    while(matches.find()){
        val hex = matches.group(1) //group(0)就是 "&#24320;", 而group(1)就是24320
        val char = Integer.parseInt(hex, 10).toChar()
        result = result.replace(matches.group(0), char.toString())
    }
    println(result)
}


internal object temp {
    @JvmStatic
    fun main(args: Array<String>) {
        val ob: Observable<*> = Observable.create<String>(ObservableOnSubscribe { emitter ->
            if (emitter.isDisposed) {
                return@ObservableOnSubscribe
            }
            emitter.onNext("hello")
            emitter.onNext("world")
            emitter.onComplete()
        })
    }
}




