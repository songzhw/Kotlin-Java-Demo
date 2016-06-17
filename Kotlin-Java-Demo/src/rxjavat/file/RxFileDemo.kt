package rxjavat.file

import rx.Observable
import rx.schedulers.Schedulers
import java.io.File

/**
 * Created by songzhw on 2016-06-16.
 */

// IMPORTANT! : if the FileUtils is a kotlin file, the getContent() will be error without any log!!!
fun main(args: Array<String>) {
    val file = File("README.md")

    // Better not write and get at the same time!

    rxWrite(file)

    rxGet(file)


    // FAILED!
//    Observable.just(file)
//        .map { file.readText() }
//        .subscribeOn(Schedulers.io())
//        .subscribe{
//            println("szw : content222 = "+it)
//        }
}

fun rxGet(file : File){

    println("szw : len = "+file.length())

    println(" szw : thread0 = "+Thread.currentThread().name) //=> main
    Observable.just(file)
            .map {
                println(" szw : thread1 = "+Thread.currentThread().name) //=> RxCachedThreadScheduler-1
                FileUtils.getFileContent(it)
            }
            .subscribeOn(Schedulers.io())
            .subscribe{
                println(" szw : thread2 = "+Thread.currentThread().name) //=> RxCachedThreadScheduler-1
                println("szw : content3 = "+it)
            }
}

fun rxWrite(file : File) {
    println("szw : len = "+file.length())

    println(" szw : thread0 = "+Thread.currentThread().name) //=> main
    Observable.just(file)
            .map {
                println(" szw : thread4 = "+Thread.currentThread().name) //=> RxCachedThreadScheduler-1
                FileUtils.saveFileContent("abc", file)
            }
            .subscribeOn(Schedulers.io())
            .subscribe{
                println(" szw : thread5 = "+Thread.currentThread().name) //=> RxCachedThreadScheduler-1
                println("szw : content6 = "+it)
            }
}