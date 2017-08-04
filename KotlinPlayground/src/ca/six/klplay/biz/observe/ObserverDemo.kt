package ca.six.klplay.biz.observe

fun main(args: Array<String>) {
    val watcher01 = Watcher01()
    val watcher02 = Watcher02()

    val loginActivity = LoginActivity()
    val logoutActivity = LogoutActivity()

    loginActivity.login()

    Thread.sleep(2000)

    logoutActivity.logout()
}

/* output:

szw login success
szw watcher02 : detect (LoggedIn)
szw watcher01 : detect (LoggedIn)

szw log out successfully
szw watcher02 : detect (LoggedOut)
szw watcher01 : detect (LoggedOut)

 */