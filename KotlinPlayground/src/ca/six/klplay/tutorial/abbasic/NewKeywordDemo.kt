package ca.six.kdemo.basic.news

fun myApply(){
    val list = ArrayList<String>()
    list.apply {
        add("one")
        add("two")
        println("this = $this") //=> [one, two]
    }.forEach{
        println("$it") //=> one, /n two
    }
}

fun myWith(){
    val list = ArrayList<String>()
    with(list){
        add("one")
        add("two")
        println("this = $this") //=> [one, two]
    } // no return value!
}

fun myLet(): Int {
    "sample".let{
        println(it)
        return 23
    }
}

fun myRun(){
    val list = ArrayList<String>()
    list.run {
        add("one")
        add("two")
        println("this = $this") //=> [one, two]
    }.let{
        println("ret = $it")  //=> Kotlin.Unit
    }
}


fun getImage(url : String){}

fun main(args: Array<String>) {

}

