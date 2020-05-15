import java.net.URLEncoder

fun main() {
    val src = """http://one?id=23&name=lucy's "home""""
    val ret = URLEncoder.encode(src, "UTF-8")
    println(ret)  //=> http%3A%2F%2Fone%3Fid%3D23%26name%3Dlucy%27s+%22home%22
}