package cn.song.adclass


/**
songzhw - 2015/8/22
Copyright 2015 Six.
 */

//the compiler automatically derives : equals(), hashCode(), toString(), copy()
data class User6(val name: String, val age: Int)

/*
NOTE that if a constructor parameter does not have a val or var in front of it,
it will not be included in computation of all these functions;
nor will be properties declared in the class body or inherited from the superclass.
 */


// --------------- copy() -------------------
val jack = User6(name = "Jack", age = 1)
val olderJack = jack.copy(age = 2)


// --------------- multi declaration -------------------
fun foo6(){   // multi declaration is only allowed for local variable/values. That's why we need a fun to contain it.
    val jane = User6("Jane", 35)
    val (name, age) = jane     // multi declaration is only allowed for local variable/values
    println("$name, $age years of age") // prints "Jane, 35 years of age"
}