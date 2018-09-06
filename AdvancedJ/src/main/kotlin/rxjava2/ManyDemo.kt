package rxjava2

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ManyDemo {
    fun doIt(scheduler: Scheduler = Schedulers.computation()): Flowable<Long> {
        val ret = Flowable.interval(500, TimeUnit.MILLISECONDS, scheduler)
                .take(10)
        return ret
    }
}