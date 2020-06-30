package biz

import kotlin.random.Random

/*
 * 发一个100元的红包, 3个人抢. 数字一是得随机, 二是得保证每人都抢到至少0.01元, 三是和得是100元
 *
 * : 所以直接Random三个数字, 不能保证第二点和第三点 (有可能第一个数字就已经100元了, 就没有给其它人留下钱了)
 *
 */

fun 算红包() {
    val money = 100f    // 红包金额
    val count = 3       // 人头

    val result = arrayListOf<Float>() //TODO 只保留两个小数
    var distributed = 0f
    for (i in 0 until count) {
        if (i == 0) {
            result.add(Random.nextFloat() * 100 + 0.01f) //[0,1)的范围, 包括了0, 所以我要加一个0.01
            distributed = result[i]
        } else if (i == count - 1) {
            result.add(money - distributed)
        } else {
            val left = money - distributed
            result.add(Random.nextFloat() * left + 0.01f)
            distributed += result[i]
        }
    }

    println("result = $result")
    println("和= ${result.reduce { acc, now -> acc + now }}")
}

fun main() {
    算红包()
}