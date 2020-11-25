package ca.six.thread_i54w

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import java.util.function.Predicate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lock = ReentrantLock()
        val turnOfA = lock.newCondition()
        val turnOfB = lock.newCondition()
        val t1 = Thread(RoPrint1To100(lock, myCondition = turnOfA, anotherCondition = turnOfB) { num -> num % 2 == 1 })
        val t2 = Thread(RoPrint1To100(lock, myCondition = turnOfB, anotherCondition = turnOfA) { num -> num % 2 == 0 })

        btnMain.setOnClickListener {
            t1.start()
            t2.start()
        }
    }
}


class RoPrint1To100(val lock: Lock, val myCondition: Condition, val anotherCondition: Condition, val p: Predicate<Int>) : Runnable {
    override fun run() {
        for (i in 1..100) {
            if (p.test(i)) {
                lock.lock();
                try {
                    println("RoB run $i")
                    anotherCondition.signal()
                    myCondition.await()
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}