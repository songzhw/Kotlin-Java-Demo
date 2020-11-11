package ca.six.kjdemo.data


import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*
import kotlin.experimental.xor

fun sha1(text: String): ByteArray {
    val sha1 = MessageDigest.getInstance("SHA-1")
    sha1.update(text.toByteArray(StandardCharsets.ISO_8859_1), 0, text.length)
    return sha1.digest()
}

fun main() {
    val MOD = 20

    val key = "urn:uuid:9aad8fa1-c4f2-4037-bb72-9e308755b91d"
    val keyData = sha1(key)
    val srcData = "hello world".toByteArray()

    val size = srcData.size
    for (i in 0 until size) {
        srcData[i] = srcData[i] xor keyData[i % MOD]
    }

    println(srcData.joinToString(","))
    println(Base64.getEncoder().encodeToString(srcData)) //=> ElAvIGBZgPBU7gs=
}

//=> AAAAAAAAAAAMCygkCw1KCQUF

