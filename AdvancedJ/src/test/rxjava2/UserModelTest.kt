package rxjava2

import bean.User
import org.junit.Assert.*
import org.junit.Test

class UserModelTest {
    lateinit var  users : List<User>

    @Test
    fun test01() {
        val model = UserModel()
        model.getUsers()
                .subscribe { users ->
                    this.users = users
                }
        assertEquals(0, users.size)
    }

}