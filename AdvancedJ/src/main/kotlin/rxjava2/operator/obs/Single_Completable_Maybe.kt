package rxjava2.operator.obs

import io.reactivex.Maybe
import io.reactivex.MaybeOnSubscribe

fun main(args: Array<String>) {
    maybe_()
}

fun maybe_() {
    http_isUserExist()
            .subscribe({/*onSuccess*/}, {/*onError*/}, {/*onComplete*/})
}

fun http_isUserExist(): Maybe<String> {
    val randomBool = Math.random() < 0.5

    return Maybe.create { emitter ->
        if (randomBool) {
            emitter.onSuccess("json from http")
            emitter.onComplete()
        } else {
            emitter.onError(Error("http error"))
        }
    }
}