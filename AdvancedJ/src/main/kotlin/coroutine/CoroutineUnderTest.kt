package coroutine

import kotlinx.coroutines.delay

class CoroutineUnderTest {

    suspend fun getInfo(id: Int) : String {
        val request = "request$Int"
        delay(1000)
        println("001")
        delay(1000)
        println("002")
        delay(1000)
        println(request)
        return request
    }

}