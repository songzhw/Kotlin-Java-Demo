package biz

import kotlin.random.Random

/*
 * 发一个100元的红包, 3个人抢. 数字一是得随机, 二是得保证每人都抢到至少0.01元, 三是和得是100元
 *
 * : 所以直接Random三个数字, 不能保证第二点和第三点 (有可能第一个数字就已经100元了, 就没有给其它人留下钱了)
 */

fun 算红包() {
    val money = 100f    //红包金额
    val count = 3       //人头

    val m1 = Random.nextFloat() * 100
    val m2 = Random.nextFloat() * 100
    val m3 = Random.nextFloat() * 100
    println("$m1, $m2, $m3, 和=${m1 + m2 + m3}")
}

fun main() {
    算红包()
}