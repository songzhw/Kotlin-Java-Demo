package rxjava2

import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.TestSubscriber
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.matchers.JUnitMatchers.hasItem
import utils.ImmediateSchedulerRule

class HttpEngineTest {

    @Rule @JvmField val scheduler = ImmediateSchedulerRule()

    @Test fun getItemDetail() {
        val http = HttpEngine()
        val testSubscriber = TestSubscriber<String>()

        http.getItemDetail()
                .subscribeOn(Schedulers.io())
                .subscribe(testSubscriber)

        testSubscriber.assertComplete()
        assertThat(testSubscriber.values(), hasItem("from server"))
    }
}