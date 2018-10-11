package rxjava2.fortest

import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import utils.ImmediateSchedulerRule

class ProfilePresenterTest {
    @Rule @JvmField val scheduler = ImmediateSchedulerRule()
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
        verify(view).refresh(expected)
    }
}