package ca.six.algo.array_string

// Is Unique: Implementation an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

// 1. 如果string是个ASCII的string, 那数量有限, 可以用桶排序似的方法
// 2. 用bit来存的话, 比boolean[256]占用更少的空间 (java中, boolean的大小取决于虚拟机. 但可以近似认为是int来存, 即4个byte)
   // 现在假设string是一个lowercase的a到z字母, 这样26 < 32, 一个int就够了.
fun isUnique2(src: String): Boolean {
	for(char in src){
		val charIndex = char.toInt(); // a 97; b 98;

	}
	return true
}

fun main(args: Array<String>) {
	println("unique? = ${isUnique2("abcde")}")  //=> true
	println("unique? = ${isUnique2("abcade")}") //=> false
}

/*
kotlin中位运算, 可没有符号. 而是and, or, xor (与, 或, 异或)
inv(), shl(), shr(), ushr() 则是按位取反, 左移, 右移, 无符号右移
 */