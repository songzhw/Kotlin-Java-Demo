package ca.six.algo.array

/*
给定一个数组与值A,  在数组中找到和为A的两个整数, 返回这两个整数的下标
如输入是[2, 3, 7, 11]与9, 那就要返回[0, 2]
 */

fun main() {
    val ary = intArrayOf(2, 3, 7, 11)
    val target = 9
    approach1(ary, target)  // O(n^2) ;  不借助其它空间
    approach2(ary, target)  // O(n) ;
    approach3(ary, target)  // O(n) ;
}

fun approach1(ary: IntArray, target: Int) {
    ary.forEachIndexed { index1, i ->
        ary.forEachIndexed { index2, j ->
            if (i + j == target) {
                println("index1 = [$index1, $index2]")
                return  //不加这个, 就有两处结果[0, 2] 与 [2, 0]
            }
        }
    }
}

fun approach2(ary: IntArray, target: Int) {
    val map = hashMapOf<Int, Int>()
    ary.forEachIndexed { index, num ->
        map.put(num, index)
    }
    map.forEach { k, v ->
        val another = target - v
        if (map.containsKey(another)) {
            println("index2 = [${map[v]}, ${map[another]}]")
            return@forEach  //直接用return会报错: "return is not allowed here"
        }
    }
}

fun approach3(ary: IntArray, target: Int) {
    val map = hashMapOf<Int, Int>()
    ary.forEachIndexed { index, num ->
        map.put(num, index)
        val another = target - num
        if (map.containsKey(another)) {
            println("index2 = [${map[num]}, ${map[another]}]")
            return
        }
    }
}