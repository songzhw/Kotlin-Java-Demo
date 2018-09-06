package utils

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import junit.framework.AssertionFailedError
import java.util.ArrayList

object RxAssertions2 {

    fun <T> subscribeAssertingThat(observable: Observable<T>): ObservableAssertions<T> {
        return ObservableAssertions(observable)
    }

    class ObservableAssertions<T>(observable: Observable<T>) {

        private val mResult: MutableList<T>
        private var mError: Throwable? = null
        private var mCompleted: Boolean = false

        init {
            mCompleted = false
            mResult = ArrayList()
            observable.subscribeOn(Schedulers.trampoline())
                    .subscribe(
                            { item -> mResult.add(item) },
                            { error -> mError = error },
                            { mCompleted = true })
        }

        fun completesSuccessfully(): ObservableAssertions<T> {
            if (!mCompleted || mError != null) {
                if (mError != null) mError!!.printStackTrace()
                throw AssertionFailedError("Observable has not completed successfully - cause: " + if (mError != null) mError else "onComplete not called")
            }
            return this
        }

        fun fails(): ObservableAssertions<T> {
            if (mError == null) {
                throw AssertionFailedError("Observable has not failed")
            }
            return this
        }

        fun failsWithError(throwable: Throwable): ObservableAssertions<T> {
            fails()
            if (throwable != mError) {
                throw AssertionFailedError("Observable has failed with a different error," +
                        " expected is " + throwable + " but thrown was " + mError)
            }
            return this
        }

        fun hasSize(numItemsExpected: Int): ObservableAssertions<T> {
            if (numItemsExpected != mResult.size) {
                throw AssertionFailedError("Observable has emitted " + mResult.size
                        + " items but expected was " + numItemsExpected)
            }
            return this
        }

        @SafeVarargs
        fun emits(vararg itemsExpected: T): ObservableAssertions<T> {
            completesSuccessfully()
            assertEmittedEquals(*itemsExpected)
            return this
        }

        fun emitsNothing(): ObservableAssertions<T> {
            completesSuccessfully()
            if (mResult.size > 0) {
                throw AssertionFailedError("Observable has emitted " + mResult.size + " items")
            }
            return this
        }

        private fun assertEmittedEquals(vararg itemsExpected : T) {
            hasSize(itemsExpected.size)
            for (i in itemsExpected.indices) {
                val expected = itemsExpected[i]
                val actual = mResult[i]
                if (expected != actual) {
                    throw AssertionFailedError("Emitted item in position " + i + " does not match," +
                            "  expected " + expected + " actual " + actual)
                }
            }
        }

    }
}