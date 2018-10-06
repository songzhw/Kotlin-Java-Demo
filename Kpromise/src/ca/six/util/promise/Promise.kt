package ca.six.util.promise

class Promise<T>(resolve: Function1<T, Promise<T>>, reject: Function1<Throwable, Promise<T>>) {

    fun then(actioner: Function1<T, Promise<T>>) {

    }

}

fun main(args: Array<String>) {
    
}