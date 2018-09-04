
fun main(args: Array<String>) {
    var a = 1
    var b = 2

    a = b.also { b = a }
    println("(1).  $a, $b")  //=> (1). 2, 1

    a = 1
    b = 2
    with(b){
        b = a
        a = this
    }
    println("(2).  $a, $b")  //=> (2).  2, 1
}