package rxjava2.fortest

import io.reactivex.schedulers.TestScheduler
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import utils.ImmediateSchedulerRule


class ProfilePresenterTest {

    val scheduler = TestScheduler()
    @Rule @JvmField val rule = ImmediateSchedulerRule(scheduler)

    @Mock lateinit var view : IProfileView

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onClickMine() {
        println("szw test onClickMine() : thread = ${Thread.currentThread().name}")
        val expected = Profile("szw")

        val presenter = ProfilePresenter(view)
        presenter.onClickMine()

        scheduler.triggerActions()

        verify(view).refresh(expected)
    }
}