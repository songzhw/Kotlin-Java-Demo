package ca.six.algo.tree

import java.util.*

val color = arrayOf("黑", "白")
val size = arrayOf("10'", "8'")
val ram = arrayOf("64G", "256G")

fun allSku(vararg skus: Array<String>) {
    val results = arrayListOf<String>()
    val stack = Stack<String>()
    val skuSize = skus.size

    var index = 0
    for (i in skus[index].size - 1 downTo 0) {
        stack.push(skus[index][i]) //倒序遍历, 再加上栈, 才有正常的输出顺序
    }

    val oneResult = ArrayList<String>()
    while (!stack.isEmpty()) {
        oneResult.add(stack.pop())
        println("index = $index; stack = $stack, oneResult = $oneResult, results = $results")

        if (index == skuSize - 1) {
            results.add(oneResult.toString())
            oneResult.removeAt(oneResult.size - 1)
        } else {
            index++
            val thisSku = skus[index]
            for (i in thisSku.size - 1 downTo 0) {
                stack.push(thisSku[i])
            }
        }


//        println(results)
    }
}

fun main() {
    allSku(color, size)

//    for(index in 10 downTo 7) print(index)  //=> 10, 9, 8, 7
}


