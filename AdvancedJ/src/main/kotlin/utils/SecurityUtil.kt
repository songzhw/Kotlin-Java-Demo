package utils

import java.security.MessageDigest

fun String.sha512() : String{
    val bytes : ByteArray = MessageDigest.getInstance("SHA-512")
            .digest(this.toByteArray())
    return bytes.toHex()

}

fun ByteArray.toHex() : String{
    val sb = StringBuilder()
    this.forEach { value ->
        val hexInt = value.toInt() and (0xFF)
        val hexString = Integer.toHexString(hexInt)
        if(hexString.length == 1){
            sb.append("0")
        }
        sb.append(hexString)
    }
    return sb.toString()

}

fun String.salt() : String{
    val pwdSalt = "biu-gO82nx_d" + this +"_8dnx0%sdc"
    val pwdInSha = pwdSalt.sha512()
    return pwdInSha
}

fun main(args: Array<String>) {
    println("Renran4".salt()) //=> cfe3d11e25d864f9c5370ac839062c83e014ae261b5d7f8029348c448939780b5f3136f5974bf4d9219d6e742069ddf7860ecc1ca6b9e27d7b5ca3d259b4c5fc
    println("594szw".salt())  //=> 54c57e3b29df8a913897885eb7706a70c41776ba20bfddadab21bf728b2be84966344b92f47fed2ceac37df8a3be9dd2d856cdf064a3df6beb984c8a83ecb349
}