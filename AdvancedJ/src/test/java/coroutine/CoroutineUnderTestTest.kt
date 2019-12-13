package coroutine

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class CoroutineUnderTestTest {

    @Test
    fun getInfo_pass1_getRequest1() {
        val target = CoroutineUnderTest()
        val value = runBlocking { target.getInfo(1) }
        assertEquals("1", value)
    }

}