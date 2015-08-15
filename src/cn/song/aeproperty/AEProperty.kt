package cn.song.aeproperty

public class Address01{
    //     public var name : String //error
    // error "Property must be initialized or be abstract"!
    public var name : String = "song"

    val id = 23L
    //    public val id = 23L //error!
    // error : "protected or public member shoulde have specificed type"


}


fun main(args: Array<String>) {
    var add1 = Address01()
    add1.name = "xl"
    // add1.id = 24L //error, because of "val", not "var"
    println(add1.name+add1.id)//xl23
}