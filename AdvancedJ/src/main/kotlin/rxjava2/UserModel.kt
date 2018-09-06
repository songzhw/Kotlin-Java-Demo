package rxjava2

import bean.User
import io.reactivex.Observable

class UserModel {
    fun getUsers() : Observable<List<User>> {
        val list = List(3) { i->
            User(i.toLong(), "user$i", true)
        }
        return Observable.just(list)
    }
}