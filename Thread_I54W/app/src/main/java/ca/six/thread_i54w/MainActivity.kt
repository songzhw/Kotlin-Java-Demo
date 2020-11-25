package ca.six.thread_i54w

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lock = ReentrantLock()
        val turnOfA = lock.newCondition()
        val turnOfB = lock.newCondition()
        val t1 = Thread(RoA(lock, turnOfA, turnOfB))
        val t2 = Thread(RoB(lock, turnOfA, turnOfB))


        btnMain.setOnClickListener {
            t1.start()
            t2.start()
        }
    }
}

class RoA(val lock: Lock, val conditionA: Condition, val conditionB: Condition) : Runnable {
    override fun run() {
        for (i in 1..100) {
            if (i % 2 == 1) {
                lock.lock();
                try {
                    println("RoA run $i")
                    conditionB.signal()
                    conditionA.await()
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

class RoB(val lock: Lock, val conditionA: Condition, val conditionB: Condition) : Runnable {
    override fun run() {
        for (i in 1..100) {
            if (i % 2 == 0) {
                lock.lock();
                try {
                    println("RoB run $i")
                    conditionA.signal()
                    conditionB.await()
                } finally {
                    lock.unlock();
                }
            }
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