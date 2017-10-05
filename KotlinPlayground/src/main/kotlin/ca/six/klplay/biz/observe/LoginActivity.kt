package ca.six.klplay.biz.observe

class LoginActivity {
    fun login(){
        println("szw login success")
        LoginObservable.notifyStateChanged(LoginState.LoggedIn)
    }
}