package coroutine

import org.junit.Test

import org.junit.Assert.*

class CoroutineUnderTestTest {

    @Test
    suspend fun getInfo_pass1_getRequest1() {
        val target = CoroutineUnderTest()
        val value = target.getInfo(1)
        println(value)
    }
}