package cn.song.aeproperty

public class Address01{
    //     public var name : String //error
    // error "Property must be initialized or be abstract"!
    public var name : String = "song"

    val id = 23L
    //    public val id = 23L //error!
    // error : "protected or public member shoulde have specificed type"

    val tmp : String
        get() = "bing"

    var resp : String
        get() = "json"
        set(value){
            println("resp.set($value)")
        }

    var resp2 : String = "sample resp2"
        get() = "json2"
        set(value){
            println("resp2.set($value)")
            field = "[$value]"
        }

    var resp3 : String = "init data3"
        set(value){
            println("resp3.set($value)")
            field = "[$value]"
        }
}


fun main(args: Array<String>) {
    var add1 = Address01()
    add1.name = "xl"
    // add1.id = 24L //error, because of "val", not "var"
    println(add1.name+add1.id)  //=> xl23

    println(add1.resp)  //=> json
    println(add1.resp2) //=> json2
    println(add1.resp3) //=> init data3

    add1.resp = "23"  //=> resp.set(23)
    add1.resp2 = "24" //=> resp2.set(24)
    add1.resp3 = "25" //=> resp3.set(25)
    println(add1.resp)  //=> json
    println(add1.resp2) //=> json2
    println(add1.resp3) //=> [25]

}