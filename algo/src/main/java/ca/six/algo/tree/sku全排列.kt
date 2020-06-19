package ca.six.algo.tree

import java.util.*

val color = arrayOf("黑", "白")
val size = arrayOf("10'", "8'")
val ram = arrayOf("64G", "256G")

fun allSku(result: ArrayList<Array<String>>, vararg skuList: Array<String>) {
    loop(arrayOf<String>(), 0, result, *skuList);

    for(ary in result){
        println(ary.asList())
    }
}

fun loop(prevWork: Array<String>, skuIndex: Int, result: ArrayList<Array<String>>, vararg skuList: Array<String>) {
    val currentSkus = skuList[skuIndex]
    val isLastSkus = skuIndex == (skuList.size - 1)
    for (sku in currentSkus) {
        val work = prevWork + sku
        if (isLastSkus) result.add(work)
        else {
            val newIndex = skuIndex + 1
            loop(work, newIndex, result, *skuList)
        }
    }
}

fun main() {
    val result = ArrayList<Array<String>>()
    allSku(result, color, size)


    // println( (color + "ru").asList())  //=> [黑, 白, ru]

//    for(index in 10 downTo 7) print(index)  //=> 10, 9, 8, 7
}


