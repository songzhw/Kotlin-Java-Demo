package how.lambda

inline fun repeat2(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun repeat3(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun main(args: Array<String>) {
    var a2 = 0
    repeat2(100_000_000) {
        a2 += 1
    }

    var b3 = 0
    repeat3(100_000_000) {
        b3 += 1
    }
}