package rxjava2

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.MockitoAnnotations

class HttpEngineTest {
    @Test fun getItemDetail() {
        val http = HttpEngine()
        http.getItemDetail()
                .subscribe { detail ->
                    assertEquals("xxxx", detail)
                }
    }
}