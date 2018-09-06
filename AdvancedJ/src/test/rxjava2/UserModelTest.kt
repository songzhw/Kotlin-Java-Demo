package rxjava2

import bean.User
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Test

class UserModelTest {
    var  users : List<User> = ArrayList()

    @Test
    fun test01() {
        val model = UserModel()
        model.getUsers()
                .observeOn(Schedulers.io())
                .subscribe { users ->
                    this.users = users
                }
        assertEquals(3, users.size)

    }

}