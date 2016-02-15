package kotlin_sample.dex_counter

/**
 * Created by songzhw on 2016/2/15.
 */
fun main(args: Array<String>) {
    var sample = DexCount04()
    println(sample.testType("Ljava/lang/String"))
}

class DexCount04 {
    fun testType(type : String) : String {
        if(type.startsWith("L")){
            var name = type.substring(1 .. type.length-1)
            return name.replace('/', ',')
        }
        return "void"
    }
}