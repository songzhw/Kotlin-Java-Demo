package java_kt

import java.io.File

fun deleteDir(to: String) {
    File(to).deleteRecursively()
}