fun main() {
    val root = "/storage/emulated/0/android/data/com.some.android/files/8316fc740455e9eeed3dc644cfead4ab/epubs/"
    val path =
        "/storage/emulated/0/android/data/com.some.android/files/8316fc740455e9eeed3dc644cfead4ab/epubs/15989428-0244-4808-bc54-22f51961efbb-3/oebps/brow_9780385537865_epub_c81_r1.htm"
    var result = path.removePrefix(root)
    println(result)
    val start = result.indexOf("/")
    result = result.substring(start + 1)
    println(result) // note that it has to be equal exactly, "A" and "a" are not equal here


}
