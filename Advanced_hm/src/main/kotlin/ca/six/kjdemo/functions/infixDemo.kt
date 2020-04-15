package ca.six.kjdemo.functions

/*
infix:
  1). 必须得是 成员函数 或 扩展函数
  2). 它们必须只有一个参数. 参数不能是变长, 也不能有默认值
 */

infix fun Int.addx(x: Int): Int = this + x
fun Int.addy(x: Int) = this + x

fun main() {
    val v1 = 1 addx 3  //=> 4
//    val v2 = 2 addy 3
}



