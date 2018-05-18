import java.net.URL

data class A(val id: Int, val time: Long) {
}

fun main(args: Array<String>) {
    val list: List<A> = arrayListOf<A>(A(11, 20), A(23, 20), A(11, 23), A(17, 24))
    list
            .sortedWith(Comparator<A> { a1, a2 ->
                if(a1.id == a2.id){
                    a2.time.compareTo(a1.time)
                } else {
                    a2.id.compareTo(a1.id)
                }
            })
//            .take(3)
            .forEach { A ->
                println("$A")
            }
/*
Comparator<A> { a1, a2 ->
                a2.id.compareTo(a1.id)
            }
 */

    val url = URL("https://github.com/ckeditor/ckeditor5/issues/991")
    println("host = ${url.host}, path = ${url.path}")

    val query = "github.com google test"
    val querys = query.split(" ")
    querys.forEach { println(it) }


    // 跳出两层循环
    /*
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            println("$i, $j")
            if (i > 2 && j > 3) break@loop
        }
    } //打印完1,2后, 打印3-1, 3-2, 3-3, 3-4, 就完了


    // 跳出内层循环. 3-4后是4-1, 打到4-4, 接着是5-1, ..., 一直到10-3, 10-4
    for (i in 1..10) {
        for (j in 1..10) {
            println("$i, $j")
            if (i > 2 && j > 3) break
        }
    }
    */

    // Error
    /*
     val ary1 = arrayOf(1, 2, 3, 4)
     val ary2 = arrayOf(1, 2, 3)
     ary1.forEach { n1 ->
         inner@ ary2.forEach { n2 ->
             println("$n1, $n2")
             if(n1 > 2 && n2 > 1) {
                 return@inner
             }
         }
     }
     */

//
//    val ary1 = arrayOf(1, 2, 3, 4)
//    val ary2 = arrayOf(1, 2, 3)
//    ary1.forEach inner@{ n1 ->
//        ary2.forEach { n2 ->
//            println("$n1, $n2")
//            if (n1 > 2 && n2 > 1) {
//                return@inner
//            }
//        }
//    }


//    val num1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    val num2 = listOf(11, 12, 13, 14)
//    num1.forEach { n1 ->
//        num2.forEach{ n2 ->
//            println("$n1, $n2")
//            if(n1 > 5 && n2 > 12) {
//                return@forEach
//            }
//        }
//    }
}