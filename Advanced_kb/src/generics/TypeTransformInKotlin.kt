package generics
//
//import generics.java.data.*
//import java.util.ArrayList
//
//
//fun main() {
//    val cow = Animal()
//    val cat = Cat()
//    val dog = Dog()
//
//    var list: MutableList<out Animal> = ArrayList()
//    list.add(cow)
//    list.add(cat)
//    list.add(dog)
//    val anim = list[0]
//    list = ArrayList<Cat>()
//
//    var list5: MutableList<in Animal> = ArrayList()
//    list5.add(cow)
//    list5.add(cat)
//    list5.add(dog)
//    val anim5 = list5[0] //因为自带out, 所以可以读取(这与java不同)
//    list5 = ArrayList<Being>()
//
//    var list2 = ArrayList<Animal>()
//    list2.add(cow)
//    list2.add(cat)
//    list2.add(dog)
//    val anim2 = list[0]  // 能读, 也能写
//    list2 = ArrayList<Cat>() // 不能被赋值
//}