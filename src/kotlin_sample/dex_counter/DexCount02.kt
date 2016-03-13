package kotlin_sample.dex_counter

import java.io.File
import java.io.FileInputStream
import java.util.*

/**
 * Created by songzhw on 2016/2/13.
 */


fun main(args: Array<String>) {
    var sample = DexCount02()
    sample.testFold1()
    sample.testFold2()
    sample.testFold3()
}

class DexCount02 {

    fun testFold1(){
        var ints = arrayListOf(1, 2, 3, 4, 5)
        var sum = ints.fold(10){init, arg ->
            init + arg  // 10-1, 11-2, 13-3, 16-4, 20-5
        }
        println("test01 = "+sum)     //=> test01 = 25
    }

    fun testFold2(){
        var ints = arrayListOf(1, 2, 3, 4, 5)
        var sum = 0
        var result = ints.fold("sum"){ initial, arg ->
            sum = sum + arg     // 1, 3, 6, 10, 15
            "$initial = $sum"   // "sum = 1", "sum = 1 = 3", ...
        }
        println("|| = ($result)")  //=> || = (sum = 1 = 3 = 6 = 10 = 15)
    }

    fun testFold3(){
        var bytes : List<ByteArray> = arrayListOf("README.md")
                .map { FileInputStream(File (it.toString())) }
                .map { it.readBytes()}
                .toList()

        // fold(initial. operation) :  Accumulates value starting with initial value and applying operation from left to right to current accumulator value and each element.
        var result = bytes.fold(ClassAndDexCollection()){  sample, bytes ->

            sample
        }
    }

    internal class ClassAndDexCollection {
        val classes = ArrayList<ByteArray>()
        val dexes = ArrayList<ByteArray>()
    }
}