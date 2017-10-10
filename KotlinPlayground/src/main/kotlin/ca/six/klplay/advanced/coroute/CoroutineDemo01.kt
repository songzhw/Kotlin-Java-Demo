package ca.six.klplay.advanced.coroute

import kotlinx.coroutines.experimental.*

fun foo() {
    launch(CommonPool) {
        delay(1000L)
        println("World1")
    }

    print("Hello ")
    Thread.sleep(2000L)
}//=> Hello, 1秒后world. 再1秒后结束应用

fun fo2() {
    launch(CommonPool) {
        delay(1000L)
        println("World2")
    }

    print("Hello ")
    Thread.sleep(500L)
} //=> Hello, 半秒后应用结束. (始终没有打印出来world)


// Thread.sleep 会阻塞主线程，而非阻塞函数 delay 只会延迟协程的执行
fun fo3() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World3!")
    }

    print("Hello ")
    delay(2000L)
} //=> 效果类似foo(), 但其实不像Thread.sleep一样会堵塞住


fun fo4() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World4!")
    }

    print("Hello ")
    delay(600L)
} //=> 效果类似fo2(), 但其实不像Thread.sleep一样会堵塞住

// join(): 等待协程的工作完
fun fo5() = runBlocking<Unit> {
    val job = launch(CommonPool) {
        delay(1000)
        println("World5")
    }
    print("Hello ")
    job.join()
}

// without "suspend", we will get a error:
//    "delay" should be called only from a coroutine or another suspended function
fun fo6(myFun: () -> Unit) = runBlocking<Unit> {
    var job = launch(CommonPool) {
        delay(1000)
        myFun()
    }

    print("Hello ")
    job.join()
}


fun world6(){
    println("World6")
}

/*
//往数据库插入10条数据，然后界面提示
fun insertDBData() {
    val addJob = async(CommonPool,false) {
        val arrays = mutableListOf<DBBo>()
        for(i in 1..10){ random {
            arrays.add(DBBo("id$i${it.nextInt(1000)}",it.nextInt(1000),"info${it.nextInt(1000)}"))
        } }
        kApplication.dbOpt!!.getDao(DBBo::class.java).replaceObjs(arrays)
    }
    launch(UI) {
        showComfirmCrouton("${addJob.await()}条数据添加成功!")
    }
}
*/

fun getData() : Int {
    Thread.sleep(4000)
    println("szw sleep over")
    return 100
}

fun refresh(value : Int) {
    println("szw : refresh $value")
}

fun requestAndRefresh(){
    val outter = async {
        val job : Deferred<Int> = async (CommonPool){
            getData()
        }
        refresh(job.await())
    }
    outter.join()
}


fun main(args: Array<String>) {
    requestAndRefresh()

//    fo6(world6()) //=> This is just like "fo6(Unit)"
    // 传递函数, 下面二方法都行
/*    fo6({ world6()})
    fo6 { world6() }*/
    /*
    fo6 {world6()} 的结果, 是第一个World6和第二个Hello一起出现
    因为我们前面在join()了嘛, 所以没有两个Hellow一起出来!
     */
}

// https://baiyangcao.github.io/notes/2017/06/20/kotlin-coroutines.html
// http://www.jianshu.com/p/d4a8358e843e