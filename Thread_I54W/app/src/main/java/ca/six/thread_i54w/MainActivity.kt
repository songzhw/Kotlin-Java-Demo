package ca.six.thread_i54w

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.thread_i54w.biz.RoPrint1To100
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import java.util.function.Predicate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnMain.setOnClickListener {
        }
    }
}




/*
val barrier = CyclicBarrier(2)
val t1 = Print1To20Runnable(1, barrier)
val t2 = Print1To20Runnable(2, barrier)
Thread(t1).start()
Thread(t2).start()

btnMain.setOnClickListener {
    for (i in 1..100) {
        println(i)
        if (i % 2 == 0) t1.print(i)
        if (i % 2 == 1) t2.print(i)
    }

class Print1To20Runnable(val id: Int, val barrier: CyclicBarrier) : Runnable {
    var isRunning = true

    override fun run() {
        while (isRunning) {

            Thread.sleep(100)
        }
    }

    fun print(num: Int) {
        println("thread($id) -- $num")
        barrier.await()
    }
}
*/