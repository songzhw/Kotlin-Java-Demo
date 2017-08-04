package ca.six.klplay.biz.observe

class LogoutActivity {
    fun logout(){
        println("szw log out successfully")
        LoginObservable.notifyStateChanged(LoginState.LoggedOut)
    }
}