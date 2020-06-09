package ca.six.algo

//val list = ArrayList<Int>() //list有初始size, 超界会有IndexOutOfBoundsException
val map = HashMap<Int, Int>()

fun f(n: Int): Int {
    if (n == 0) map.put(0, 0)
    else if (n == 1) map.put(1, 1)
    else {
        var minus2 = map.get(n - 2)
        var minus1 = map.get(n - 1)
        //println("($n): minus1 = $minus1, minus2 = $minus2")
        if (minus1 == null) {
            minus1 = f(n - 1)
            map.set(n - 1, minus1)
            //println("   =+> (${n-1}) = $minus1")
        }
        if (minus2 == null) {
            minus2 = f(n - 2)
            map.set(n - 2, minus2)
            //println("   =*> (${n-2}) = $minus2")
        }
        map.put(n, minus1 + minus2!!)
    }
    return map.get(n)!!
}

fun main() {
    val start = System.currentTimeMillis()
    // println(f(66666)) //=> java.lang.StackOverflowError
    println(f(150))
    val end = System.currentTimeMillis()
    println("cost time2 = ${(end - start) / 1000f}")
}
// f(50)耗时0.005秒;  f(150)耗时0.013秒
// 当然f(66666)仍会有StackOverflowError (因为这仍是在使用递归)