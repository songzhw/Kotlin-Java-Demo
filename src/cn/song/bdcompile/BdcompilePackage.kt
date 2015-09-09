package cn.song.bdcompile

/**
 * Created by hzsongzhengwang on 2015/9/9.
 */
public class BdcompilePackage {
    fun fooa(){
        println("ccc")
    }
}

fun main(args: Array<String>) {
    var test = BdcompilePackage()
    test.fooa()
} // error : "Error running BdcompilePackage: Function 'main' not found in class BdCompilePackage"