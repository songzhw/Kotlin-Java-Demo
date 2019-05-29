package ca.six.algo.array_string

// Is Unique: Implementation an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

// 1. 如果string是个ASCII的string, 那数量有限, 可以用桶排序似的方法
fun isUnique(src: String): Boolean {
	val bucket = BooleanArray(256) // 值全为false
	for (char in src) {
		println(char.toInt()) // a 97, b 98, c 99, ...
		val charIndex = char.toInt()
		if (!bucket[charIndex]) {
			bucket[charIndex] = true
		} else {
			return false;
		}
	}
	return true
}

fun main(args: Array<String>) {
	println("unique? = ${isUnique("abcde")}")  //=> true
	println("unique? = ${isUnique("abcade")}") //=> false
}