package rxjava2

import io.reactivex.schedulers.TestScheduler
import io.reactivex.subscribers.TestSubscriber
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.TimeUnit

class ManyDemoTest {

    @Test
    fun doIt() {
        val obj = ManyDemo()

        val scheduler = TestScheduler()
        val subs = TestSubscriber<Long>()
        obj.doIt(scheduler).subscribe(subs)

        scheduler.advanceTimeBy(2, TimeUnit.SECONDS)
        subs.assertValues(0L, 1L, 2L, 3L)


        scheduler.advanceTimeTo(5, TimeUnit.SECONDS)
        subs.assertValueCount(10)
        subs.assertTerminated()
    }

}