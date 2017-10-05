package cn.song.abbasic

fun testStringEquals(){
	val s1 = "abc"
	val s2 = "abc"
	val s3 = "df"
	println("${s1 == s2}")  //=> true
	println("${s1 === s2}") //=> true
	println("${s1.equals(s2)}")//=> true (但IDE提示用 ==)

	println("==========")
	println("${s1 == s3}")  //=> false
	println("${s1 === s3}") //=> false
	println("${s1.equals(s3)}") //=> false

}