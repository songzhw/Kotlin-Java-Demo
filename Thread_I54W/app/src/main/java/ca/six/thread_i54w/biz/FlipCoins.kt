package ca.six.thread_i54w.biz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.thread_i54w.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.CountDownLatch
import kotlin.random.Random

class FlipCoinsActivity : AppCompatActivity(), IFlipCoinResult {
    val totalResult = arrayListOf<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val latch = CountDownLatch(3)
        val t1 = Thread(FlipCoinRunnable(latch, this))
        val t2 = Thread(FlipCoinRunnable(latch, this))
        val t3 = Thread(FlipCoinRunnable(latch, this))

        btnMain.setOnClickListener {
            t1.start()
            t2.start()
            t3.start()
            latch.await()

            val head = totalResult.filter { it }.size
            println("szw result is [count = ${totalResult.size}, 正面=${head}次]")
        }
    }

    override fun onResult(result: ArrayList<Boolean>) {
        totalResult.addAll(result)
    }
}

interface IFlipCoinResult {
    fun onResult(result: ArrayList<Boolean>)
}

class FlipCoinRunnable(val latch: CountDownLatch, val listener: IFlipCoinResult) : Runnable {
    override fun run() {
        val random = Random(System.currentTimeMillis())
        val count = random.nextInt(30, 100)
        println("线程N共flip${count}次")
        val result = arrayListOf<Boolean>()
        for (i in 1..count) {
            result.add(random.nextBoolean())
        }
        listener.onResult(result)
        latch.countDown()
    }
}