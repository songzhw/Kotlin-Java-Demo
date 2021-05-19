package ca.six.algo.biz.查找缺失的整数


fun main() {
    // 要找到1到10之间缺失的那个整数 (无重复元素)
    val ary = intArrayOf(1, 3, 7, 9, 10, 4, 6, 2, 5)

    // 方法一: 排序, 再与1..10的遍历比较.  排序耗时O(nlogn), 空间上是O(1)

    // 方法二: 新建一个hashmap, 来存放src中数据. 这样再从1..10中遍历, 找到不存在的key就是缺失的值了
    // 时间上O(n), 空间上O(n)

    // 方法三: 时间上O(n), 空间上O(1)
    val sumOughtToBe = (1..10).reduce { acc, i -> acc + i }
    val sumWeGot = ary.reduce { acc, i -> acc + i }
    println("find it: ${sumOughtToBe - sumWeGot}")
}