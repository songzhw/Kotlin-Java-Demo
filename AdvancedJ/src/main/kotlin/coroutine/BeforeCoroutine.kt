package coroutine

import java.util.concurrent.CompletableFuture

fun getId(): CompletableFuture<Int> {
    return CompletableFuture.supplyAsync {
        println("get ID: ${Thread.currentThread().name}") //=> get ID: ForkJoinPool.commonPool-worker-9
        Thread.sleep(2000)
        20 // no return here
    }
}

fun getUser(id: Int): CompletableFuture<String> {
    println("get User :  ${Thread.currentThread().name}")  //=> main
    return CompletableFuture.supplyAsync { "user($id)  ${Thread.currentThread().name}" } //=> user(20)  ForkJoinPool.commonPool-worker-9]
}

fun getInfo(user: String): CompletableFuture<String> {
    println("get Info:  ${Thread.currentThread().name}") //=> main
    return CompletableFuture.supplyAsync { "getInfo()  ${Thread.currentThread().name} : from $user" } //=> [getInfo()  ForkJoinPool.commonPool-worker-9 : from user(20)  ForkJoinPool.commonPool-worker-9]
}


fun main() {
    getId()
        .thenCompose { id -> getUser(id) }
        .thenCompose { user -> getInfo(user) }
        .thenAccept { info -> println("szw result = [$info] ||  ${Thread.currentThread().name}") }
        .exceptionally { err ->
            err.printStackTrace();
            null
        }
        .join()
}