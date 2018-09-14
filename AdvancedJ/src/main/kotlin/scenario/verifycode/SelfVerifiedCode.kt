package scenario.verifycode

fun generateCode(productId: String) : String{
    var sum1 = 0
    var sum2 = 0
    val chars = productId.toCharArray()
    for (i in 0 until productId.length) {
        val num = chars[i] - '0'
        sum1 += num * (10 - i)
        sum2 += num * (7 + i)
    }

    val suffix1 = getSuffix(sum1)
    val suffix2 = getSuffix(sum2)
    return productId + suffix1 + suffix2

}

fun getSuffix(sum : Int) : String{
    val mod = sum % 11
    val result = (11 - mod) % 11 //结果为11, 就要变成0. 因为每个校验码都只有一位
    val suffix = if (result == 10) "x" else "" + result
    return suffix
}

fun main(args: Array<String>) {
    println("output = " + generateCode("155192370"))
    println("output = " + generateCode("140007917"))
    println("output = " + generateCode("037541457"))
    println("output = " + generateCode("037428158"))
}