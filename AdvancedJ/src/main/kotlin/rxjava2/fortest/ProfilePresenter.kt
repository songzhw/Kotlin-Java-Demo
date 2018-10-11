package rxjava2.fortest

class ProfilePresenter(private val view: IProfileView) {
    private val http: FakeHttpClient = FakeHttpClient()

    fun onClickMine() {
        val profile = http.fetchProfile()
        view.refresh(profile)
    }

}