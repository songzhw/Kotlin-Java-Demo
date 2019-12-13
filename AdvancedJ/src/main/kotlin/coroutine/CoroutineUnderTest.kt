package coroutine

import kotlinx.coroutines.delay

class CoroutineUnderTest {

    suspend fun getInfo(id: Int): String {
        val request = "request$Int"
        delay(3000)
        return request
    }

}