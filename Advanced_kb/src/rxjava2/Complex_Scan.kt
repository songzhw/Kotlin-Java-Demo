package rxjava2

import io.reactivex.Observable

data class Bx(val id: Int)
data class BxWrapper(val bx: Bx)

fun main() {


}

class Complex_Scan {
    fun work() {
        Observable.just(Bx(10), Bx(12), Bx(15))
            .scanWith(this::one, this::two)
    }

    fun one(): BxWrapper {
        val three = Bx(33)
        return BxWrapper(three)
    }

    fun two(bx: Bx): BxWrapper {
        return BxWrapper(bx)
    }

}

