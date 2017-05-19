package kotlin_sample.builder

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */

// because html() return a Html, so the result of result() is a Html object
fun result() =
        html {
            head {
                title("_Hello Kotlin Builder_")
            }
        }


fun main(args: Array<String>) {
    println(result())
}