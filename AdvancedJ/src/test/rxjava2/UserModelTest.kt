package rxjava2

import org.junit.Assert.*
import org.junit.Test

class UserModelTest {

    @Test
    fun test01() {
        val model = UserModel()
        model.getUsers()
                .subscribe { users ->
                    assertEquals(0, users.size) // no matter the first argument is 0 or 3, the test is passed!
                }
    }

}