package scenario.verifycode

fun generateCode(productId: String) : String{
    var sum = 0
    val chars = productId.toCharArray()
    for (i in 0 until productId.length) {
        val num = chars[i] - '0'
        if (num < 0 || num > 9) {
            throw IllegalArgumentException("argument should be a valid productID")
        }
        sum += num * (10 - i)
    }

    val mod = sum % 11
    val result = (11 - mod) % 11 // to make sure result will not be "11"
    val suffix = if (result == 10) "x" else "" + result
    return productId + suffix

}

fun main(args: Array<String>) {
    println("output = " + generateCode("155192370"))
    println("output = " + generateCode("140007917"))
    println("output = " + generateCode("037541457"))
    println("output = " + generateCode("037428158"))
}