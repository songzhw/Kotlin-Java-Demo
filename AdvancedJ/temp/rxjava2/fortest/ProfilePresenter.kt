package rxjava2.fortest

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ProfilePresenter(private val view: IProfileView) {
    private val http: FakeHttpClient = FakeHttpClient()

    fun onClickMine() {
        Flowable.fromCallable { http.fetchProfile() }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe { profile ->
                    view.refresh(profile)
                }
    }

}