package ca.six.kjdemo

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import kotlin.concurrent.thread
import kotlin.experimental.xor

interface IAnimal {
    fun hunt()
}

class Cat : IAnimal {
    override fun hunt() {
        println("cat hunt")
    }
}

class Dog : IAnimal {
    override fun hunt() {
        println("dog hunt")
    }
}

interface IRun {
    fun run()
}

fun IAnimal.run() {
    println("$this run")
}

fun Cat.run(){
    println("my cat run")
}

fun main() {
    val cat = Cat()
    cat.run() //=> my cat run

    val dog = Dog()
    dog.run() //=> ca.six.kjdemo.Dog@7440e464 run
}