package coroutine

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class CoroutineUnderTestTest {

    @Test
    fun getInfo_pass1_getRequest1() = runBlocking {
        val target = CoroutineUnderTest()
        val value  = target.getInfo(1)
        assertEquals("1", value)
    }

}