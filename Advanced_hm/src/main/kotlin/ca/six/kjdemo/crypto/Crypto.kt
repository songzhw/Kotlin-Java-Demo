package ca.six.kjdemo.crypto

import java.security.GeneralSecurityException
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class Crypto {

    fun encrypt(src: String): String {
        val keyBytes = getRealKey(userId, deviceId, rawKey)

        val key = SecretKeySpec(keyBytes, "AES/ECB/PKCS7Padding")
        val cipher = Cipher.getInstance("AES/ECB/PKCS7Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val result = cipher.doFinal(src.toByteArray())
        val ret = Base64.encodeToString(result, Base64.DEFAULT)
        return ret
    }
}

fun main() {
    val obj = Crypto()
    val ret = obj.encrypt("hello world")
    println("encrypted = $ret")
}