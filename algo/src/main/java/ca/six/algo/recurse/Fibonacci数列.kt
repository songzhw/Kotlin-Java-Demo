package ca.six.algo.recurse

fun bad_recursive_fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    else return bad_recursive_fibonacci(n - 1) + bad_recursive_fibonacci(n - 2)
}

fun main() {
//    println("fibonnaci : ${fibonacci(4)}")
//    println("fibonnaci : ${fibonacci(5)}")
    val start = System.currentTimeMillis()
    println("fibonnaci : ${bad_recursive_fibonacci(50)}")
    val end = System.currentTimeMillis()
    println("cost time = ${(end - start) / 1000f}")
}

// f(30)耗时0.006秒; f(40)耗时0.413秒; f(50)是48.397秒; f(100)执行了20多分钟都没有结束; (其实f(60)就已经等了好久都没有结果