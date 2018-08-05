fun <T> Array<T>.exchange(i: Int, j: Int) {
    this[i] = this[j].also {
        this[j] = this[i]
    }
}