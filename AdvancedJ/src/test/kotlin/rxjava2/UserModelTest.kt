package rxjava2

import bean.User
import io.reactivex.subscribers.TestSubscriber
import org.junit.Assert.*
import org.junit.Test
import utils.RxAssertions2

class UserModelTest {
    var users: List<User> = ArrayList()

    // 结论: 笨重
    @Test
    fun test01() {
        val model = UserModel()
        model.getUsers()
                .subscribe { users ->
                    this.users = users
                }
        assertEquals(3, users.size)
    }

    // 结论: 有缺陷
    // RxAssertions1是RxJava1时代的类. 还有Schedules.immediate()等东东
    @Test
    fun test02() {
        val model = UserModel()
        RxAssertions2.subscribeAssertingThat(model.getUsers())
                .completesSuccessfully()
                .hasSize(1)  // RxAssertions2有点小缺陷. 因为它是just(list), 所以这里是size为1. 但一般人想的都是List中有三个users, 所以这里应该hasSize(3)才对
    }




}