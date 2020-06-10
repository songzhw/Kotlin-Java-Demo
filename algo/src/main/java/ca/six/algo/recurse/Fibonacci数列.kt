package ca.six.algo.recurse

fun bad_recursive_fibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    else return bad_recursive_fibonacci(n - 1) + bad_recursive_fibonacci(n - 2)
}

// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

val map = HashMap<Int, Int>()

fun good_recursive_fibonacci(n: Int): Int {
    if (n == 0) map.put(0, 0)
    else if (n == 1) map.put(1, 1)
    else {
        var minus2 = map.get(n - 2)
        var minus1 = map.get(n - 1)
        //println("($n): minus1 = $minus1, minus2 = $minus2")
        if (minus1 == null) {
            minus1 = good_recursive_fibonacci(n - 1)
            map.set(n - 1, minus1)
            //println("   =+> (${n-1}) = $minus1")
        }
        if (minus2 == null) {
            minus2 = good_recursive_fibonacci(n - 2)
            map.set(n - 2, minus2)
            //println("   =*> (${n-2}) = $minus2")
        }
        map.put(n, minus1 + minus2)
    }
    return map.get(n)!!
}


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
fun fibonacci(n: Int): Long {
    if (n == 0) return 0
    if (n == 1) return 1

    var result = 0L
    var minus2 = 0L
    var minus1 = 1L
    for (i in 2..n) {
        result = minus1 + minus2;
        minus2 = minus1
        minus1 = result
        println("($n) n-1 = $minus1, n-2 = $minus2")
    }
    return result
}


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
fun main() {
//    println("fibonnaci : ${fibonacci(4)}")
//    println("fibonnaci : ${fibonacci(5)}")
    val start = System.currentTimeMillis()
    println("fibonnaci : ${fibonacci(66666)}")
    val end = System.currentTimeMillis()
    println("cost time = ${(end - start) / 1000f}")
}

// bad_recursive_fibonacci(30)耗时0.006秒; bad_recursive_fibonacci(40)耗时0.413秒; bad_recursive_fibonacci(50)是48.397秒; bad_recursive_fibonacci(100)执行了20多分钟都没有结束; (其实bad_recursive_fibonacci(60)就已经等了好久都没有结果
// good_recursive_fibonacci(50)耗时0.005秒; good_recursive_fibonacci(150)耗时0.013秒 || 当然good_recursive_fibonacci(66666)仍会有StackOverflowError (因为这仍是在使用递归)
// fibonacci(50)耗时0.002秒; fibonacci(150)耗时0.006秒; fibonacci(66666)不栈溢出, 耗时0.231秒