package ca.six.klplay.advanced.delegation

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Apple {
    var id : String by IdPropertyDelegate()
    val date : String by DatePropertyDelegate()
}

class DatePropertyDelegate : ReadOnlyProperty<Apple, String> {
    override fun getValue(thisRef: Apple, property: KProperty<*>): String {
        return "${property.name} from $thisRef"    }
}

class IdPropertyDelegate : ReadWriteProperty<Apple, String> {
    override fun getValue(thisRef: Apple, property: KProperty<*>): String {
        return "${property.name} from $thisRef"    }

    override fun setValue(thisRef: Apple, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef")
    }

}

fun main(args: Array<String>) {
    val apple = Apple()
    apple.id = "23"      //=> 23 has been assigned to id in Apple@37f8bb67
    println(apple.id)    //=> id from Apple@37f8bb67
    println(apple.date)  //=> date from Apple@37f8bb67
}
